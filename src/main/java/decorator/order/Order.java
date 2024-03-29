package decorator.order;

public interface Order {
    /**
     * @return total price of order in cents
     */
    int calculateTotalPrice();
}
