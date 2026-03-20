import java.util.*;

class InvalidBookingException9 extends Exception {

    InvalidBookingException9(String msg) {
        super(msg);
    }
}

class Inventory9 {

    HashMap<String, Integer> map;

    Inventory9() {

        map = new HashMap<>();

        map.put("Single", 1);
        map.put("Double", 1);
        map.put("Suite", 0);
    }

    void book(String type) throws InvalidBookingException9 {

        if (!map.containsKey(type)) {
            throw new InvalidBookingException9("Invalid Room Type");
        }

        if (map.get(type) <= 0) {
            throw new InvalidBookingException9("No Availability");
        }

        map.put(type, map.get(type) - 1);

        System.out.println(type + " booked");
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        Inventory9 inv = new Inventory9();

        try {

            inv.book("Single");

            inv.book("Suite");   // no availability

            inv.book("King");    // invalid type

        } catch (InvalidBookingException9 e) {

            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("System running safely");
    }
}