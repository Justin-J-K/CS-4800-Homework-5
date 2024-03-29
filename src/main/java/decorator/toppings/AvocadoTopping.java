package decorator.toppings;

import decorator.food.Food;

public class AvocadoTopping extends Topping {
    public AvocadoTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 250;
    }
}
