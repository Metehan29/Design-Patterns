package ReservationSystem;

class Cash implements Payment {
    public void pay(double total, String cur) {

        double amountAsInt = (int) total;
        //deneme 
        System.out.println(amountAsInt + " " + curr + " Cash will be accepted.");
    }
}
