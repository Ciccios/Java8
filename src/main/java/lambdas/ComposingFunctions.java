package lambdas;


import model.Apple;

import java.util.List;
import java.util.function.Predicate;

public class ComposingFunctions {

    public static Predicate<Apple> redApples = a -> a.getColor().equals(Apple.AppleColor.RED);

    public static Predicate<Apple> yellowApples = a -> a.getColor().equals(Apple.AppleColor.YELLOW);

    public static Predicate<Apple> redOrYellowApples = redApples.or(a -> a.getColor().equals(Apple.AppleColor.YELLOW));

    public static Predicate<Apple> notRedApples = redApples.negate();

    public static Predicate<Apple> lessThan25Apples = a -> a.getWeight() < 25;

    public static Predicate<Apple> redAndLessThan25Apples = redApples.and(lessThan25Apples);

    public static void main(String[] args) {
        List<Apple> apples = Main.getApples();

        List<Apple> redApples = Filtering.filterApples(apples, ComposingFunctions.redApples);
        System.out.println("Red Apples list: " + redApples);

        List<Apple> yellowApples = Filtering.filterApples(apples, ComposingFunctions.yellowApples);
        System.out.println("Yellow Apples list: " + yellowApples);

        List<Apple> redAndYellowApples = Filtering.filterApples(apples, redOrYellowApples);
        System.out.println("Red and Yellow Apples list: " + redAndYellowApples);

        List<Apple> redAndLessThan2Apples = Filtering.filterApples(apples, redAndLessThan25Apples);
        System.out.println("Red and Less Than 25 Apples list: " + redAndLessThan2Apples);

        List<Apple> notRedApples = Filtering.filterApples(apples, ComposingFunctions.notRedApples);
        System.out.println("Not Red Apples list: " + notRedApples);
    }
}
