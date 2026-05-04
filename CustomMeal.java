package ReservationSystem;

public class CustomMeal implements Reservation {
    private String name;
    private double price;
    private boolean extraSauce;
    private boolean extraBeverage;

    private CustomMeal(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.extraSauce = builder.extraSauce;
        this.extraBeverage = builder.extraBeverage;
    }

    public String getDescription() {
        String desc = name;
        if (extraSauce) desc += " + Extra Sauce";
        if (extraBeverage) desc += " (Extra Beverage)";
        return desc;
    }

    public double getCost() {
        double total = price;
        if (extraSauce) total += 20.0;
        if (extraBeverage) total += 50.0;
        return total;
    }


    public static class Builder {
        private String name;
        private double price;
        private boolean extraSauce = false;
        private boolean extraBeverage = false;

        public Builder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Builder addExtraSauce() {
            this.extraSauce = true;
            return this;
        }

        public Builder addExtraBeverage() {
            this.extraBeverage = true;
            return this;
        }

        public Builder setGlutenFree() {
            this.extraBeverage = true;
            return this;
        }

        public CustomMeal build() {
            return new CustomMeal(this);
        }
    }
}