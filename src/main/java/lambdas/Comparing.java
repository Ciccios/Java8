package lambdas;

import model.Apple;

import java.util.Comparator;

public class Comparing {

    //With types in the lambdas parameters
    public static Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    //Type inference will recognize automatically the type of the input on the left side of the statement
    public static Comparator<Apple> byWeight2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

}
