import java.util.HashMap;

class RoomInventory {

    HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    int getAvailability(String type) {
        return inventory.get(type);
    }

    void updateAvailability(String type, int count) {
        inventory.put(type, count);
    }

    void displayInventory() {
        for (String key : inventory.keySet()) {
            System.out.println(key + " Available: " + inventory.get(key));
        }
    }
}

public class UseCase3InventorySetup {

    static String version = "Hotel Booking System v3.1";

    public static void main(String[] args) {

        System.out.println("Book My Stay");
        System.out.println(version);

        RoomInventory inv = new RoomInventory();

        inv.displayInventory();

        inv.updateAvailability("Single", 4);

        System.out.println("After Update");

        inv.displayInventory();
    }
}
