package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReferences {

    //Instance method
    public Function<Apple, Integer> weight = a -> a.getWeight();
    public Function<Apple, Integer> weightReference = Apple::getWeight;


    //Static method reference
    public Function<Apple, Integer> count = a -> Apple.getCount();
    //Compile error as we are not passing argument to the method list from parameter list
    //public Function<Apple, Integer> countReference = Apple::getCount;

    public UnaryOperator<String> uppperCase = (String s) -> s.toUpperCase();
    public UnaryOperator<String> uppperCaseReference = String::toUpperCase;

}
