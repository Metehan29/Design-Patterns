package ReservationSystem;

class PaymentFactory {
    public static Payment getMethod(int choice) {
        return (choice == 1) ? new CreditCard() : new Cash();
    }
}