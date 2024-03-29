package decorator.food;

public class HotDog implements Food {
    @Override
    public int calculatePrice() {
        return 400;
    }
}
