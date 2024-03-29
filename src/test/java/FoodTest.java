import decorator.food.Burger;
import decorator.food.Fries;
import decorator.food.HotDog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {

    @Test
    public void testBurgerCosts500() {
        assertEquals(500, new Burger().calculatePrice());
    }

    @Test
    public void testHotDogCosts400() {
        assertEquals(400, new HotDog().calculatePrice());
    }

    @Test
    public void testFriesCosts200() {
        assertEquals(200, new Fries().calculatePrice());
    }
}
