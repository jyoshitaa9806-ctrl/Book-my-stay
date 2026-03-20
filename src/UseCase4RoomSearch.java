import java.util.HashMap;

abstract class Room4 {

    String type;
    double price;

    Room4(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display() {
        System.out.println(type + " Price: " + price);
    }
}

class SingleRoom4 extends Room4 {
    SingleRoom4() {
        super("Single", 1000);
    }
}

class DoubleRoom4 extends Room4 {
    DoubleRoom4() {
        super("Double", 2000);
    }
}

class SuiteRoom4 extends Room4 {
    SuiteRoom4() {
        super("Suite", 5000);
    }
}

class RoomInventory4 {

    HashMap<String, Integer> inventory;

    RoomInventory4() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 0);
        inventory.put("Suite", 2);
    }

    int getAvailability(String type) {
        return inventory.get(type);
    }
}

public class UseCase4RoomSearch {

    static String version = "Hotel Booking System v4.0";

    public static void main(String[] args) {

        System.out.println("Book My Stay");
        System.out.println(version);

        RoomInventory4 inv = new RoomInventory4();

        Room4 r1 = new SingleRoom4();
        Room4 r2 = new DoubleRoom4();
        Room4 r3 = new SuiteRoom4();

        if (inv.getAvailability("Single") > 0) {
            r1.display();
            System.out.println("Available: " + inv.getAvailability("Single"));
        }

        if (inv.getAvailability("Double") > 0) {
            r2.display();
            System.out.println("Available: " + inv.getAvailability("Double"));
        }

        if (inv.getAvailability("Suite") > 0) {
            r3.display();
            System.out.println("Available: " + inv.getAvailability("Suite"));
        }
    }
}
