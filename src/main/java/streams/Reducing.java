package streams;

import model.Person;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reducing {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        //Generating an infinite stream of natural numbers
        int sumUnboxed = IntStream.iterate(1, x -> x + 1)
                                  .limit(5000000)
                                  .sum();

        long time = System.currentTimeMillis() - start;
        System.out.println(sumUnboxed + " in " + time + " ms");


        long start2 = System.currentTimeMillis();
        Integer sum = Stream.iterate(0, x -> x + 1).limit(5000000)
                .reduce(0, Integer::sum);

        long time2 = System.currentTimeMillis() - start2;
        System.out.println(sum + " in " + time2 + " ms");


        Optional<Integer> reduced = Stream.of(1, 2, 3, 4, 5, 6)
                                          .reduce((x, y) -> x + y);

        //Using accumulator only. It is a BinaryFunction taking two args in input of type T and giving same type T in return in an optional
        Optional<Integer> reduce1 = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce((x, y) -> x + y);

        //Using accumulator only. It is a BinaryFunction taking two args in input of type T and giving same type T in return non in optional
        // as we give an initial value (identity for the combiner function)
        Integer reduce2 = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce(5, (x, y) -> x + y);

        System.out.println("REDUCE1: " + reduce1);
        System.out.println("REDUCE2: " + reduce2);

        Person defaultPerson = Person.getPersons().stream()
                                                  .findAny()
                                                  .orElseGet(() -> new Person("", "", 0, ""));
        System.out.println(defaultPerson);
    }
}
