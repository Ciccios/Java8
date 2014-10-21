package lambdas;

import model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filtering {

    //Imperative
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if(Apple.AppleColor.GREEN.equals(apple.getColor())) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    //More generic
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if(predicate.test(apple)) {
                filteredApples.add(apple); //Added only if the passed predicate matches the condition
            }
        }
        return filteredApples;
    }
}
