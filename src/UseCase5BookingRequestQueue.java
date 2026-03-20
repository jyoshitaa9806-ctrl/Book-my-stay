import java.util.LinkedList;
import java.util.Queue;

class Reservation5 {

    String guestName;
    String roomType;

    Reservation5(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(guestName + " requested " + roomType);
    }
}

class BookingQueue5 {

    Queue<Reservation5> queue;

    BookingQueue5() {
        queue = new LinkedList<>();
    }

    void addRequest(Reservation5 r) {
        queue.add(r);
    }

    void showRequests() {
        for (Reservation5 r : queue) {
            r.display();
        }
    }
}

public class UseCase5BookingRequestQueue {

    static String version = "Hotel Booking System v5.0";

    public static void main(String[] args) {

        System.out.println("Book My Stay");
        System.out.println(version);

        BookingQueue5 q = new BookingQueue5();

        q.addRequest(new Reservation5("A", "Single"));
        q.addRequest(new Reservation5("B", "Double"));
        q.addRequest(new Reservation5("C", "Suite"));

        System.out.println("Booking Requests in Order:");

        q.showRequests();
    }
}