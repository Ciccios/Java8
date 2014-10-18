package lambdas;

public class Apple {

    private static int count = 0;
    private final int id;
    private AppleColor color;

    public enum AppleColor {
        GREEN, RED, YELLOW;
    }

    public static Apple newApple(AppleColor color){
        return new Apple(count++, color);
    }

    private Apple(int id, AppleColor color) {
        this.id = id;
        this.color = color;
    }

    public AppleColor getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Apple number '" + id + "' of color " + color;
    }
}
