import java.util.*;

class Inventory10 {

    HashMap<String, Integer> map;

    Inventory10() {

        map = new HashMap<>();

        map.put("Single", 1);
        map.put("Double", 1);
        map.put("Suite", 1);
    }

    void add(String type) {
        map.put(type, map.get(type) + 1);
    }

    void reduce(String type) {
        map.put(type, map.get(type) - 1);
    }

    int get(String type) {
        return map.get(type);
    }
}

class BookingService10 {

    Inventory10 inv;

    HashMap<String, String> bookings;

    Stack<String> rollback;

    BookingService10() {

        inv = new Inventory10();

        bookings = new HashMap<>();

        rollback = new Stack<>();
    }

    void book(String id, String type) {

        if (inv.get(type) > 0) {

            inv.reduce(type);

            bookings.put(id, type);

            rollback.push(id);

            System.out.println(id + " booked " + type);
        }
    }

    void cancel(String id) {

        if (!bookings.containsKey(id)) {

            System.out.println("Invalid cancel");
            return;
        }

        String type = bookings.get(id);

        inv.add(type);

        bookings.remove(id);

        rollback.push(id);

        System.out.println(id + " cancelled");
    }

    void showInventory() {

        System.out.println("Inventory");

        for (String k : inv.map.keySet()) {

            System.out.println(k + " " + inv.map.get(k));
        }
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        BookingService10 s = new BookingService10();

        s.book("R1", "Single");

        s.showInventory();

        s.cancel("R1");

        s.showInventory();

        s.cancel("R1");   // invalid
    }
}