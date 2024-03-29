package decorator.order;

import decorator.food.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodOrder implements Order {
    private final List<Food> foods;

    public FoodOrder() {
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public int calculateTotalPrice() {
        int total = 0;

        for (Food food : foods) {
            total += food.calculatePrice();
        }

        return total;
    }

}
