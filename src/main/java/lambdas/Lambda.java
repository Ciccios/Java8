package lambdas;

import model.Apple;

import java.util.function.Predicate;

public class Lambda {

    public Predicate<Apple> greenApples = a -> a.getColor().equals(Apple.AppleColor.GREEN);

}
