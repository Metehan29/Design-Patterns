package ReservationSystem;

class CreditCard implements Payment {
    public void pay(double a, String cur) {
        int amountAsInt = (int) a;

        System.out.println(amountAsInt + " " + cur + " Will be purchased with a card.");
    }
}