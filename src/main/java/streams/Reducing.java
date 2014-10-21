package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reducing {

    public static void main(String[] args) {

        //Generating an infinite stream of natural numbers
        IntStream unlimitedStream = IntStream.iterate(1, x -> x + 1);

        long start = System.currentTimeMillis();
        int sumUnboxed = unlimitedStream.limit(5000000)
                .sum();
        long time = System.currentTimeMillis() - start;
        System.out.println(sumUnboxed + " in " + time + " ms");


        long start2 = System.currentTimeMillis();
        Integer sum = Stream.iterate(0, x -> x + 1).limit(5000000)
                .reduce(0, Integer::sum);

        long time2 = System.currentTimeMillis() - start2;
        System.out.println(sum + " in " + time2 + " ms");
    }
}
