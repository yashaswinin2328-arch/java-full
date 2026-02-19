import java.util.*;

public class Taxi {
    int taxiId;
    char currentSpot;
    int freeTime;
    int totalEarnings;
    List<Booking> bookings;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentSpot = 'A'; 
        this.freeTime = 0;      
        this.totalEarnings = 0;
        bookings = new ArrayList<>();
    }

    public void addBooking(Booking b) {
        bookings.add(b);
        totalEarnings += b.amount;
        currentSpot = b.to;
        freeTime = b.dropTime;
    }
}
