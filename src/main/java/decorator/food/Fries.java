package decorator.food;

public class Fries implements Food {
    @Override
    public int calculatePrice() {
        return 200;
    }
}
