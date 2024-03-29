package decorator.toppings;

import decorator.food.Food;

public class MayoTopping extends Topping {
    public MayoTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 50;
    }
}
