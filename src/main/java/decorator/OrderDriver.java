package decorator;

import decorator.food.Burger;
import decorator.food.Food;
import decorator.food.Fries;
import decorator.food.HotDog;
import decorator.order.FoodOrder;
import decorator.order.LoyaltyDiscount;
import decorator.order.Order;
import decorator.toppings.*;

public class OrderDriver {
    public static void main(String[] args) {
        FoodOrder order = new FoodOrder();

        Food hotDog = new TomatoTopping(new MayoTopping(new HotDog()));
        Food burger = new PicklesTopping(new LettuceTopping(new Burger()));
        Food fries = new CheeseTopping(new KetchupTopping(new Fries()));

        order.addFood(hotDog);
        order.addFood(burger);
        order.addFood(fries);

        printPrice("Total Price: $%d.%02d\n", order.calculateTotalPrice());

        Order discountedOrder = new LoyaltyDiscount(order, LoyaltyDiscount.LoyaltyStatus.BRONZE);

        printPrice("Total Price With Bronze Discount: $%d.%02d\n", discountedOrder.calculateTotalPrice());

        discountedOrder = new LoyaltyDiscount(order, LoyaltyDiscount.LoyaltyStatus.GOLD);

        printPrice("Total Price With Gold Discount: $%d.%02d\n", discountedOrder.calculateTotalPrice());
    }

    private static void printPrice(String format, int price) {
        int dollars = price / 100;
        int cents = price % 100;

        System.out.printf(format, dollars, cents);
    }
}
