package streams.parallelprocessing;

import java.util.stream.IntStream;

public class ParallelStream {


    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();

        /**
         * Summing elements using a single thread serially
         */
        IntStream.iterate(0, x -> x + 1)
                 .limit(1000000)
                 .sum();

        System.out.println("Sequential sum took " + (System.currentTimeMillis() - start1) + " ms");

        long start2 = System.currentTimeMillis();


        /**
         * Summing elements using multiple threads with parallel stream
         */
        IntStream.iterate(0, x -> x + 1)
                 .parallel()
                 .limit(1000000)
                 .sum();

        System.out.println("Parallel sum took " + (System.currentTimeMillis() - start2) + " ms");
    }
}
