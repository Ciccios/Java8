package streams.parallelprocessing;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        /**
         * Summing elements using reduce serially
         */
        long start2 = System.currentTimeMillis();
        Stream.iterate(0L, x -> x + 1)
                 .limit(1000000)
                 .reduce(0L, Long::sum);

        System.out.println("Sequential sum took " + (System.currentTimeMillis() - start2) + " ms");

        /**
         * Summing elements using multiple threads with parallel stream
         */
        long start3 = System.currentTimeMillis();

        Stream.iterate(0L, x -> x + 1)
                 .parallel()
                 .limit(1000000)
                 .reduce(0L, Long::sum);

        System.out.println("Parallel sum took " + (System.currentTimeMillis() - start3) + " ms");


        /**
         * Another parallel and sequential measurement
         */

        System.out.println("Sequential sum done in: " +
                measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");

        System.out.println("Parallel sum done in: " +
                measureSumPerf(ParallelStream::parallelSum, 10_000_000) + " msecs" );


        /**
         * Reducing with primitive specialized stream
         */
        long start4 = System.currentTimeMillis();

        IntStream.iterate(0, x -> x + 1)
                .limit(10000000)
                .sum();

        System.out.println("Sequential sum with primitive stream took " + (System.currentTimeMillis() - start4) + " ms");

        /**
         * Reducing with primitive specialized stream
         */
        long start5 = System.currentTimeMillis();

        IntStream.iterate(0, x -> x + 1)
                .limit(10000000)
                .sum();

        System.out.println("Parallel sum with primitive stream took " + (System.currentTimeMillis() - start5) + " ms");


        System.out.println("Sequential Ranged sum done in: " +
                measureSumPerf(ParallelStream::sequentialRangeSum, 10_000_000) + " msecs" );

        System.out.println("Parallel Ranged sum done in: " +
                measureSumPerf(ParallelStream::parallelRangeSum, 10_000_000) + " msecs" );
    }

    public static long sequentialRangeSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .sum();
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .parallel()
                         .sum();
    }



    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }


    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }


}
