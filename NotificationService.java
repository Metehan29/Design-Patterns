package ReservationSystem;

class NotificationService implements OrderObserver {
    @Override
    public void update(String name, String description) {

        System.out.println("[SMS]: " + name + ", your table has been reserved for: " + description);
    }
}