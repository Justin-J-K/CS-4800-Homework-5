package decorator.order;

public class LoyaltyDiscount implements Order {

    private final Order order;
    private LoyaltyStatus status;

    public LoyaltyDiscount(Order order, LoyaltyStatus status) {
        this.order = order;
        this.status = status;
    }

    @Override
    public int calculateTotalPrice() {
        int percentPriceDiscounted = 100 - status.discountPercent;
        return order.calculateTotalPrice() * percentPriceDiscounted / 100;
    }

    public enum LoyaltyStatus {
        BRONZE(10), // 10%
        SILVER(25), // 25%
        GOLD(50);   // 50%

        private final int discountPercent;

        LoyaltyStatus(int discountPercent) {
            this.discountPercent = discountPercent;
        }
    }
}
