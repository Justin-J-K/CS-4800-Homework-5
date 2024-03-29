import decorator.food.Burger;
import decorator.order.FoodOrder;
import decorator.order.LoyaltyDiscount;
import decorator.order.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

    private static final FoodOrder BASE_ORDER = new FoodOrder();

    @BeforeAll
    public static void addOneBurgerToBaseOrder() {
        BASE_ORDER.addFood(new Burger());
    }

    public static Stream<Arguments> provideLoyaltyStatusAndPrice() {
        return Stream.of(
                Arguments.of(new LoyaltyDiscount(BASE_ORDER, LoyaltyDiscount.LoyaltyStatus.BRONZE), 450),
                Arguments.of(new LoyaltyDiscount(BASE_ORDER, LoyaltyDiscount.LoyaltyStatus.SILVER), 375),
                Arguments.of(new LoyaltyDiscount(BASE_ORDER, LoyaltyDiscount.LoyaltyStatus.GOLD), 250)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLoyaltyStatusAndPrice")
    public void testOrderIsProperlyDiscounted(Order order, int expected) {
        assertEquals(expected, order.calculateTotalPrice());
    }

}
