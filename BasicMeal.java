package ReservationSystem;

class BasicMeal implements Reservation {
    private String name;
    private double price;
    // PR için deneme
    public BasicMeal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return name;
    }

    public double getCost() {
        return price;
    }
}
