import java.util.*;

public class TaxiBookingSystem {

    static List<Taxi> taxis = new ArrayList<>();
    static int bookingIdCounter = 1;

    // Create taxis
    public static void createTaxis(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    // Distance between points in KM
    public static int calculateDistance(char from, char to) {
        return Math.abs(from - to) * 15;
    }

    // Time taken between points (1 hour per point)
    public static int calculateTime(char from, char to) {
        return Math.abs(from - to);
    }

    // Fare Calculation
    public static int calculateFare(int distance) {
        if (distance <= 5) {
            return 100;
        }
        return 100 + (distance - 5) * 10;
    }

    // Booking method
    public static void bookTaxi(int customerId, char pickup, char drop, int pickupTime) {

        List<Taxi> freeTaxis = new ArrayList<>();

        // Step 1: Get free taxis
        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) {
                freeTaxis.add(t);
            }
        }

        // Step 2: If no taxi is free reject booking
        if (freeTaxis.isEmpty()) {
            System.out.println(" Booking Rejected. No Taxi Available.");
            return;
        }

        // Step 3: Choose nearest taxi
        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi t : freeTaxis) {
            int distanceToPickup = calculateDistance(t.currentSpot, pickup);

            if (distanceToPickup < minDistance) {
                minDistance = distanceToPickup;
                selectedTaxi = t;
            }
            // If same distance choose taxi with lowest earnings
            else if (distanceToPickup == minDistance) {
                if (t.totalEarnings < selectedTaxi.totalEarnings) {
                    selectedTaxi = t;
                }
            }
        }

        // Step 4: Calculate fare and drop time
        int tripDistance = calculateDistance(pickup, drop);
        int tripTime = calculateTime(pickup, drop);

        int dropTime = pickupTime + tripTime;
        int fare = calculateFare(tripDistance);

        // Step 5: Create booking
        Booking b = new Booking(bookingIdCounter, customerId, pickup, drop, pickupTime, dropTime, fare);
        bookingIdCounter++;

        // Step 6: Update taxi
        selectedTaxi.addBooking(b);

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + selectedTaxi.taxiId + " is allotted");
        System.out.println(" Fare: Rs." + fare);
    }

    // Display Taxi details
    public static void displayTaxiDetails() {
        for (Taxi t : taxis) {

            System.out.println("\n------------------------------------------");
            System.out.println("Taxi-" + t.taxiId + "   Total Earnings: Rs." + t.totalEarnings);
            System.out.println("------------------------------------------");

            if (t.bookings.isEmpty()) {
                System.out.println("No Bookings Yet.");
                continue;
            }

            System.out.println("BookingID  CustomerID  From  To  PickupTime  DropTime  Amount");

            for (Booking b : t.bookings) {
                System.out.println(b.bookingId + "\t\t" + b.customerId + "\t   " + b.from + "    " + b.to
                        + "\t   " + b.pickupTime + "\t\t   " + b.dropTime + "\t   " + b.amount);
            }
        }
    }
}
