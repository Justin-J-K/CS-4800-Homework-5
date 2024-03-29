package decorator.toppings;

import decorator.food.Food;

public class LettuceTopping extends Topping {
    public LettuceTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 100;
    }
}
