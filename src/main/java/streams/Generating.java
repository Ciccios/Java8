package streams;

import model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Generating {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        Apple apple1 = Apple.newApple(Apple.AppleColor.RED, 30);
        Apple apple2 = Apple.newApple(Apple.AppleColor.YELLOW, 28);
        Apple apple3 = Apple.newApple(Apple.AppleColor.GREEN, 25);
        Apple apple4 = Apple.newApple(Apple.AppleColor.GREEN, 32);
        Apple apple5 = Apple.newApple(Apple.AppleColor.RED, 40);

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);

        //All the collections can be converted in a stream
        Stream<Apple> stream = apples.stream();

        //Creating stream directly
        Stream<Apple> directStream = Stream.of(apple1, apple2, apple3, apple4, apple5);

        Stream<Integer> a = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> b = Stream.of(6, 7, 8, 9, 10);

        //Merging 2 streams with concatenation
        Stream<Integer> concat = Stream.concat(a, b);

        long count = concat.count();

        System.out.println(count);
    }
}