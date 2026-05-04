package ReservationSystem;

class NoDiscount implements DiscountStrategy {
    public double apply(double p) {
        return p;
    }
}