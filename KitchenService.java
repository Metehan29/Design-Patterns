package ReservationSystem;

class KitchenService implements OrderObserver {
    public void update(String name, String description) {
        System.out.println("[KITCHEN]: New order for " + name + " -> " + description + " is being prepared!");
    }
}