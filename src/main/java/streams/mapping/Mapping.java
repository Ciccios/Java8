package streams.mapping;

import lambdas.Main;
import model.Apple;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {


    public static void main(String[] args) {

        List<Apple> apples = Main.getApples();

        List<Apple> collect = apples.stream()
                .filter(a -> {
                    System.out.println("Filter:" + a);
                    return a.getWeight() > 20;
                })
                .map(a -> {
                    System.out.println("Map: " + a);
                    return a;
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }

}
