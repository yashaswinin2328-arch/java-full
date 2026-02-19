import java.util.*;

public class TaxiBookingSystem {

    static List<Taxi> taxis = new ArrayList<>();
    static int bookingIdCounter = 1;

    
    public static void createTaxis(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static int calculateDistance(char from, char to) {
        return Math.abs(from - to) * 15;
    }

    public static int calculateTime(char from, char to) {
        return Math.abs(from - to);
    }

    public static int calculateFare(int distance) {
        if (distance <= 5) {
            return 100;
        }
        return 100 + (distance - 5) * 10;
    }

    public static void bookTaxi(int customerId, char pickup, char drop, int pickupTime) {

        List<Taxi> freeTaxis = new ArrayList<>();

        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) {
                freeTaxis.add(t);
            }
        }

        
        if (freeTaxis.isEmpty()) {
            System.out.println(" Booking Rejected. No Taxi Available.");
            return;
        }

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi t : freeTaxis) {
            int distanceToPickup = calculateDistance(t.currentSpot, pickup);

            if (distanceToPickup < minDistance) {
                minDistance = distanceToPickup;
                selectedTaxi = t;
            }
      
            else if (distanceToPickup == minDistance) {
                if (t.totalEarnings < selectedTaxi.totalEarnings) {
                    selectedTaxi = t;
                }
            }
        }


        int tripDistance = calculateDistance(pickup, drop);
        int tripTime = calculateTime(pickup, drop);

        int dropTime = pickupTime + tripTime;
        int fare = calculateFare(tripDistance);

        Booking b = new Booking(bookingIdCounter, customerId, pickup, drop, pickupTime, dropTime, fare);
        bookingIdCounter++;

      
        selectedTaxi.addBooking(b);

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + selectedTaxi.taxiId + " is allotted");
        System.out.println(" Fare: Rs." + fare);
    }
    
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
