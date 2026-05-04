package ReservationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RestaurantFacade facade = new RestaurantFacade();

        // Singleton
        RestaurantManager.getInstance().log("The system has been started.");

        System.out.println("=== ONLINE RESERVATION ===");
        System.out.print("Your name : ");
        String name = sc.nextLine();

        List<Reservation> meals = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Pizza (350 TL)\n2. Burger (250 TL)\n3. Kebab (200 TL)\n0. Complete the order");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            if (choice == 0) break;

            if (choice == 1) {

                System.out.print("Extra sauce ? (+20 TL) (1: Yes, 0: No): ");
                int sauce = sc.nextInt();
                System.out.print("Extra beverage ? (+50 TL) (1: Yes, 0: No): ");
                int beverage = sc.nextInt();
                CustomMeal.Builder pizzaBuilder = new CustomMeal.Builder("Pizza", 350);
                if (sauce == 1) pizzaBuilder.addExtraSauce();
                if (beverage==1) pizzaBuilder.addExtraBeverage();
                meals.add(pizzaBuilder.build());
            }
            else if (choice == 2) {

                System.out.print("Gluten free? (1: Yes, 0: No): ");
                int gf = sc.nextInt();
                CustomMeal.Builder burgerBuilder = new CustomMeal.Builder("Burger", 250);
                if (gf == 1) burgerBuilder.setGlutenFree();
                meals.add(burgerBuilder.build());
            }
            else if (choice == 3) {
                meals.add(new BasicMeal("Kebab", 200));
            }
        }

        if (meals.isEmpty()) return;


        double rawTotal = 0;
        String fullDesc = "";
        for (Reservation r : meals) {
            rawTotal += r.getCost();
            fullDesc += r.getDescription() + ", ";
        }
        Reservation finalOrder = new BasicMeal(fullDesc, rawTotal);

        System.out.print("\nWould you like the dessert of the day ? (+250 TL) (1: Yes, 0: No): ");
        if (sc.nextInt() == 1) finalOrder = new CakeDecorator(finalOrder);

        System.out.print("Are you a student ? (1: Yes, 0: No): ");
        int discChoice = sc.nextInt();

        System.out.print("\nPayment unit (1: TL, 2: USD): ");
        int curChoice = sc.nextInt();

        System.out.print("Payment method (1: Credit Card, 2: Cash): ");
        int payChoice = sc.nextInt();


        facade.processReservation(name, finalOrder, discChoice, curChoice, payChoice);
    }
}