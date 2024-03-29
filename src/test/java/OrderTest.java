import decorator.food.Burger;
import decorator.food.Food;
import decorator.food.Fries;
import decorator.food.HotDog;
import decorator.order.FoodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    private FoodOrder order;

    public static Stream<Arguments> provideFoodsAndPrices() {
        return Stream.of(
                Arguments.of(new Burger(), 500),
                Arguments.of(new HotDog(), 400),
                Arguments.of(new Fries(), 200)
        );
    }

    @BeforeEach
    public void resetOrder() {
        this.order = new FoodOrder();
    }

    @Test
    public void testEmptyOrderCostsNothing() {
        assertEquals(0, order.calculateTotalPrice());
    }

    @ParameterizedTest
    @MethodSource("provideFoodsAndPrices")
    public void testOrderWithFoodPrice(Food food, int expected) {
        order.addFood(food);
        assertEquals(expected, order.calculateTotalPrice());
    }

    @Test
    public void testOrderWithMultipleCosts1100() {
        order.addFood(new Burger());
        order.addFood(new HotDog());
        order.addFood(new Fries());
        assertEquals(1100, order.calculateTotalPrice());
    }
}
