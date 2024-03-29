package decorator.toppings;

import decorator.food.Food;

public class KetchupTopping extends Topping {
    public KetchupTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 50;
    }
}
