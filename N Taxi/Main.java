import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of taxis: ");
        int n = sc.nextInt();

        TaxiBookingSystem.createTaxis(n);

        while (true) {
            System.out.println("\n========== CALL TAXI BOOKING ==========");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();

                    System.out.print("Enter Pickup Point (A-F): ");
                    char pickup = sc.next().toUpperCase().charAt(0);

                    System.out.print("Enter Drop Point (A-F): ");
                    char drop = sc.next().toUpperCase().charAt(0);

                    System.out.print("Enter Pickup Time: ");
                    int pickupTime = sc.nextInt();

                    TaxiBookingSystem.bookTaxi(custId, pickup, drop, pickupTime);
                    break;

                case 2:
                    TaxiBookingSystem.displayTaxiDetails();
                    break;

                case 3:
                    System.out.println("Thank You! Exiting...");
                    System.exit(0);

                default:
                    System.out.println(" Invalid Choice!");
            }
        }
    }
}
