package decorator.toppings;

import decorator.food.Food;

public class MustardTopping extends Topping {
    public MustardTopping(Food food) {
        super(food);
    }

    @Override
    public int calculatePrice() {
        return food.calculatePrice() + 50;
    }
}
