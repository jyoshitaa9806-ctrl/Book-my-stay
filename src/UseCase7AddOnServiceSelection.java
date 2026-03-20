import java.util.*;

class Service7 {

    String name;
    int price;

    Service7(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class AddOnManager7 {

    HashMap<String, List<Service7>> map;

    AddOnManager7() {
        map = new HashMap<>();
    }

    void addService(String resId, Service7 s) {

        map.putIfAbsent(resId, new ArrayList<>());

        map.get(resId).add(s);
    }

    void showServices(String resId) {

        int total = 0;

        if (map.containsKey(resId)) {

            for (Service7 s : map.get(resId)) {

                System.out.println(s.name + " " + s.price);
                total += s.price;
            }
        }

        System.out.println("Total AddOn Cost = " + total);
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnManager7 m = new AddOnManager7();

        String r1 = "RES1";

        m.addService(r1, new Service7("Breakfast", 200));
        m.addService(r1, new Service7("Wifi", 100));
        m.addService(r1, new Service7("Pickup", 300));

        System.out.println("Services for " + r1);

        m.showServices(r1);
    }
}