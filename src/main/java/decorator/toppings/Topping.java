package decorator.toppings;

import decorator.food.Food;

public abstract class Topping implements Food {
    protected final Food food;

    public Topping(Food food) {
        this.food = food;
    }
}
