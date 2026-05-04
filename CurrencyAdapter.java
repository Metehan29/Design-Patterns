package ReservationSystem;

class CurrencyAdapter implements USDPayment {
    private TLService tlService;

    public CurrencyAdapter(TLService tlService) {
        this.tlService = tlService;
    }

    @Override
    public double payInUSD(double amountInTL) {
        double tl = tlService.getTLAmount(amountInTL);
        return tl / 43.0;
    }
}