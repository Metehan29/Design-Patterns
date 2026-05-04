package ReservationSystem;

class StudentDiscount implements DiscountStrategy {
    public double apply(double p) {
        return p * 0.8;
    }
}
