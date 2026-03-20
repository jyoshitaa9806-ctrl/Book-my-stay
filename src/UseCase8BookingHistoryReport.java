import java.util.*;

class Reservation8 {

    String id;
    String guest;
    String type;

    Reservation8(String id, String guest, String type) {
        this.id = id;
        this.guest = guest;
        this.type = type;
    }

    void show() {
        System.out.println(id + " " + guest + " " + type);
    }
}

class BookingHistory8 {

    List<Reservation8> list;

    BookingHistory8() {
        list = new ArrayList<>();
    }

    void add(Reservation8 r) {
        list.add(r);
    }

    List<Reservation8> getAll() {
        return list;
    }
}

class ReportService8 {

    void printReport(List<Reservation8> l) {

        System.out.println("Booking Report");

        for (Reservation8 r : l) {
            r.show();
        }

        System.out.println("Total = " + l.size());
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory8 h = new BookingHistory8();

        h.add(new Reservation8("R1", "A", "Single"));
        h.add(new Reservation8("R2", "B", "Double"));
        h.add(new Reservation8("R3", "C", "Suite"));

        ReportService8 r = new ReportService8();

        r.printReport(h.getAll());
    }
}