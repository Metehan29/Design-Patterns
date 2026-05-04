package ReservationSystem;

class RestaurantManager {
    private static RestaurantManager instance;

    private RestaurantManager() {

    }

    public static RestaurantManager getInstance() {
        if (instance == null) instance = new RestaurantManager();
        return instance;
    }
    public void log(String msg)
    { System.out.println("[SYSTEM NOTE]: " + msg); }
}