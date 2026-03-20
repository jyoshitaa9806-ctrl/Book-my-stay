import java.util.*;

class Reservation6 {

    String guest;
    String type;

    Reservation6(String guest, String type) {
        this.guest = guest;
        this.type = type;
    }
}

class Inventory6 {

    HashMap<String, Integer> inv;

    Inventory6() {
        inv = new HashMap<>();

        inv.put("Single", 2);
        inv.put("Double", 1);
        inv.put("Suite", 1);
    }

    int get(String t) {
        return inv.get(t);
    }

    void reduce(String t) {
        inv.put(t, inv.get(t) - 1);
    }
}

class AllocationService6 {

    Queue<Reservation6> queue;
    Inventory6 inventory;

    HashMap<String, Set<String>> allocated;

    AllocationService6() {

        queue = new LinkedList<>();
        inventory = new Inventory6();
        allocated = new HashMap<>();

        allocated.put("Single", new HashSet<>());
        allocated.put("Double", new HashSet<>());
        allocated.put("Suite", new HashSet<>());
    }

    void addRequest(Reservation6 r) {
        queue.add(r);
    }

    void process() {

        while (!queue.isEmpty()) {

            Reservation6 r = queue.poll();

            if (inventory.get(r.type) > 0) {

                String id = r.type + "_" + (allocated.get(r.type).size() + 1);

                if (!allocated.get(r.type).contains(id)) {

                    allocated.get(r.type).add(id);
                    inventory.reduce(r.type);

                    System.out.println(
                            r.guest + " confirmed " + r.type + " RoomID:" + id);
                }

            } else {

                System.out.println(
                        r.guest + " failed no " + r.type);
            }
        }
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        AllocationService6 s = new AllocationService6();

        s.addRequest(new Reservation6("A", "Single"));
        s.addRequest(new Reservation6("B", "Single"));
        s.addRequest(new Reservation6("C", "Single"));
        s.addRequest(new Reservation6("D", "Suite"));

        s.process();
    }
}