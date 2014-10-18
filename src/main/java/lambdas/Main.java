package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(Apple.newApple(Apple.AppleColor.GREEN));
        apples.add(Apple.newApple(Apple.AppleColor.GREEN));
        apples.add(Apple.newApple(Apple.AppleColor.RED));
        apples.add(Apple.newApple(Apple.AppleColor.YELLOW));
        apples.add(Apple.newApple(Apple.AppleColor.YELLOW));

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
        Predicate<Apple> yellowApples = apple -> apple.getColor().equals(Apple.AppleColor.YELLOW);
        List<Apple> filteredYellowApples = Filtering.filterApples(apples, yellowApples);

        System.out.println(filteredYellowApples);
    }
}
