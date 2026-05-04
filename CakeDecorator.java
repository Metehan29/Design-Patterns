package ReservationSystem;

 public class CakeDecorator implements Reservation {
    private Reservation res;


    public CakeDecorator(Reservation res) {
        this.res = res; }

    public String getDescription() {

        return res.getDescription() + " + Dessert of the day ";
    }

    public double getCost() {
        return res.getCost() + 250.0;
    }
}
