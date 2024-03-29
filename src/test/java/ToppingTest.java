import decorator.food.Burger;
import decorator.food.Food;
import decorator.toppings.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {

    private static final Food BASE_FOOD = new Burger();

    public static Stream<Topping> provideToppingsCosting50() {
        return Stream.of(
                new KetchupTopping(BASE_FOOD),
                new MayoTopping(BASE_FOOD),
                new MustardTopping(BASE_FOOD)
        );
    }

    public static Stream<Topping> provideToppingsCosting150() {
        return Stream.of(
                new CheeseTopping(BASE_FOOD),
                new OnionTopping(BASE_FOOD)
        );
    }

    public static Stream<Topping> provideToppingsCosting250() {
        return Stream.of(
                new AvocadoTopping(BASE_FOOD),
                new TomatoTopping(BASE_FOOD)
        );
    }

    @ParameterizedTest
    @MethodSource("provideToppingsCosting50")
    public void testToppingsCosts50(Topping topping) {
        testToppingPrice(topping, 50);
    }

    @Test
    public void testLettuceCosts100() {
        testToppingPrice(new LettuceTopping(BASE_FOOD), 100);
    }

    @ParameterizedTest
    @MethodSource("provideToppingsCosting150")
    public void testToppingsCosts150(Topping topping) {
        testToppingPrice(topping, 150);
    }

    @Test
    public void testPicklesCosts200() {
        testToppingPrice(new PicklesTopping(BASE_FOOD), 200);
    }

    @ParameterizedTest
    @MethodSource("provideToppingsCosting250")
    public void testToppingsCosts250(Topping topping) {
        testToppingPrice(topping, 250);
    }

    private void testToppingPrice(Topping topping, int expected) {
        assertEquals(expected, topping.calculatePrice() - BASE_FOOD.calculatePrice());
    }
}
