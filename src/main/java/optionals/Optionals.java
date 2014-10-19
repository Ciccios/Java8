package optionals;

import lambdas.Apple;

import java.util.Optional;
import java.util.function.BiFunction;

public class Optionals {

    public static void main(String[] args) {

        //HOW TO CREATE AN OPTIONAL
        //Wrapper for apple
        Optional<Apple> optionalApple = Optional.empty();
        Optional<Apple> greenOptionalApple = Optional.of(Apple.newApple(Apple.AppleColor.GREEN, 35));
        System.out.println(greenOptionalApple);

        try {
            optionalApple.get();
        }
        catch(Exception e) {
            System.out.println("Ignored Exception: " + e.getMessage());
        }

        if (optionalApple.isPresent()) {
            System.out.println(optionalApple);
        } else {
            System.out.println("Value not present");
        }

        //If apple value is not present return a new one with weight of 20 and RED color
        Apple apple = optionalApple.orElse(Apple.newApple(Apple.AppleColor.RED, 20));
        System.out.println(apple);

        //Taking optional value from Supplier calling the default constructor
        Apple anAppleFromDefaultConstructor = optionalApple.orElseGet(Apple::new);
        System.out.println("FROM DEFAULT CONSTRUCTOR: " + anAppleFromDefaultConstructor);

        //Calling the multi arg constructor with a function
        BiFunction<Apple.AppleColor, Integer, Apple> appleSupplier = Apple::newApple;
        Apple suppliedApple = optionalApple.orElse(appleSupplier.apply(Apple.AppleColor.YELLOW, 25));
        System.out.println(suppliedApple);

        Optional<Object> emptyOptional = Optional.ofNullable(null);

        assert !emptyOptional.isPresent();

        Optional<Apple> optionalApple2 = Optional.of(Apple.newApple(Apple.AppleColor.GREEN, 50));
        //If a value is present, apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result.
        // Otherwise return an empty Optional.
        Optional<Apple.AppleColor> optionalAppleColor = optionalApple2.map(Apple::getColor);

        assert optionalAppleColor.isPresent();


    }
}
