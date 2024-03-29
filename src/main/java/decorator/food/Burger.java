package decorator.food;

public class Burger implements Food {
    @Override
    public int calculatePrice() {
        return 500;
    }
}
