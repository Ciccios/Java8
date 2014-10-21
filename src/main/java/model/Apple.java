package model;

public class Apple {

    private static int count = 0;
    private int id;
    private AppleColor color;
    private Integer weight;

    public Apple() { }

    public Integer getWeight() {
        return weight;
    }

    public enum AppleColor {
        GREEN, RED, YELLOW;
    }

    public static int getCount() { return count; }

    public static Apple newApple(AppleColor color, int weight){
        return new Apple(count++, color, weight);
    }

    private Apple(int id, AppleColor color, int weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public AppleColor getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Apple number '" + id + "' of color " + color + " with weight " + weight;
    }
}
