package ReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFacade {

    TLService tlService = new TLService();
    CurrencyAdapter adapter = new CurrencyAdapter(tlService);
    private List<OrderObserver> observers = new ArrayList<>();


    public RestaurantFacade() {
        observers.add(new NotificationService());
        observers.add(new KitchenService());
    }

    public void processReservation(String name, Reservation order, int discChoice, int curChoice, int payChoice) {
        // (Strategy Pattern)
        DiscountStrategy discount = (discChoice == 1) ? new StudentDiscount() : new NoDiscount();
        double finalAmountTL = discount.apply(order.getCost());

        // (Adapter Pattern)
        double targetAmount = finalAmountTL;
        String currencyLabel = "TL";
        if (curChoice == 2) {
            targetAmount = adapter.payInUSD(finalAmountTL);
            currencyLabel = "USD";
        }

        // (Factory Pattern)
        System.out.printf("\nTotal: %.2f %s%n", targetAmount, currencyLabel);
        Payment payment = PaymentFactory.getMethod(payChoice);
        payment.pay(targetAmount, currencyLabel);

        // (Observer Pattern)
        for (OrderObserver observer : observers) {
            observer.update(name, order.getDescription());
        }

        // (Singleton Pattern)
        RestaurantManager.getInstance().log("Reservation processed for " + name);
    }
}