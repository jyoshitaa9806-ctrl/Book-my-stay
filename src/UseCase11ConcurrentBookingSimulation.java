import java.util.*;

class Inventory11 {

    HashMap<String, Integer> map;

    Inventory11() {

        map = new HashMap<>();

        map.put("Single", 1);
    }

    synchronized boolean book(String type, String guest) {

        if (map.get(type) > 0) {

            map.put(type, map.get(type) - 1);

            System.out.println(guest + " booked " + type);

            return true;
        }

        System.out.println(guest + " failed");

        return false;
    }
}

class BookingThread11 extends Thread {

    Inventory11 inv;

    String guest;

    BookingThread11(Inventory11 i, String g) {

        inv = i;
        guest = g;
    }

    public void run() {

        inv.book("Single", guest);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        Inventory11 inv = new Inventory11();

        Thread t1 = new BookingThread11(inv, "A");
        Thread t2 = new BookingThread11(inv, "B");
        Thread t3 = new BookingThread11(inv, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}