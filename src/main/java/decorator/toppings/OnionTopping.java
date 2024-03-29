package decorator.toppings;

import decorator.food.Food;

public class OnionTopping extends Topping {
    public OnionTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 150;
    }
}
