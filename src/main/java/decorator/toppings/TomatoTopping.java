package decorator.toppings;

import decorator.food.Food;

public class TomatoTopping extends Topping {
    public TomatoTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 250;
    }
}
