package streams;

import lambdas.Main;
import model.Apple;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Filtering {

    /**
     * Ways to create a stream
     */
    public static void main(String[] args) {

        List<Apple> apples = Main.getApples();

        List<Apple> redApples = apples.stream()
                .filter(apple -> apple.getColor().equals(Apple.AppleColor.RED))   //Filtering red apples - intermediate operation
                .collect(toList()); //Terminal operation that triggers the above intermediate operation

        List<Apple> lessThan25 = apples.stream()
                .filter(apple -> apple.getWeight() < 25)   //Filtering red apples - intermediate operation
                .collect(toList()); //Terminal operation that triggers the above intermediate operation

        System.out.println("Red Apples: " + redApples);
        System.out.println("Less than 25: " + lessThan25);
    }
}
