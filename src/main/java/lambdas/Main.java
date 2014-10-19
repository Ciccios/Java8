package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Apple> apples = getApples();

        List<Apple> filteredGreenApples = Filtering.filterGreenApples(apples);
        System.out.println(filteredGreenApples);

        //Using Anonymous Class implementing the Predicate Functional interface
        List<Apple> filteredRedApples = Filtering.filterApples(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                if (apple.getColor().equals(Apple.AppleColor.RED)) {
                    return true;
                }
                return false;
            }
        });

        System.out.println(filteredRedApples);

        //Using lambda expression
        Predicate<Apple> yellowApples = (Apple apple) -> apple.getColor().equals(Apple.AppleColor.YELLOW);
        List<Apple> filteredYellowApples = Filtering.filterApples(apples, yellowApples);

        //Pass lambda directly to the method
        List<Apple> filteredYellowApples2
                = Filtering.filterApples(apples, apple -> apple.getColor().equals(Apple.AppleColor.YELLOW));

        List<Apple> filteredGreenApples2
                = Filtering.filterApples(apples, apple -> apple.getColor().equals(Apple.AppleColor.GREEN));

        System.out.println(filteredYellowApples);
        System.out.println(filteredYellowApples2);
        System.out.println(filteredGreenApples2);

        Collections.sort(apples, Comparing.byWeight);

        System.out.println("Sorted by weight: " + apples);
    }

    public static List<Apple> getApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(Apple.newApple(Apple.AppleColor.GREEN, 20));
        apples.add(Apple.newApple(Apple.AppleColor.GREEN, 25));
        apples.add(Apple.newApple(Apple.AppleColor.RED, 18));
        apples.add(Apple.newApple(Apple.AppleColor.YELLOW, 22));
        apples.add(Apple.newApple(Apple.AppleColor.YELLOW, 22));
        return apples;
    }
}
