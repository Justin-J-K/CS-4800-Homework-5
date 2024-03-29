package decorator.toppings;

import decorator.food.Food;

public class CheeseTopping extends Topping {
    public CheeseTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 150;
    }
}
