package decorator.toppings;

import decorator.food.Food;

public class PicklesTopping extends Topping {
    public PicklesTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 200;
    }
}
