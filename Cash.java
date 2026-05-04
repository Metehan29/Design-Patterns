package ReservationSystem;

class Cash implements Payment {
    public void pay(double total, String cur) {

        int amountAsInt = (int) total;
        System.out.println(amountAsInt + " " + cur + " Cash will be accepted.");
    }
}
