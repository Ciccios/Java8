package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AddersAndAccumulators {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Now trying to make a fixed number of increments to see how much time it takes with AtomicLong
         */

        AtomicLong atomicIncrementer = new AtomicLong();
        Runnable increment = () -> {
            long numIncrement = 10_000_000;
            for (int i = 0; i < numIncrement; i++) {
                atomicIncrementer.incrementAndGet();
            }
        };

        long incremented = 0;
        System.out.println("Executing 10 times the AtomicLong Increment of 100Million increments spread across 10 threads");
        for (int i = 0; i < 10; i++) {
            ExecutorService executorService2 = Executors.newFixedThreadPool(10);
            long incrementerStart = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                executorService2.submit(increment);
            }
            executorService2.shutdown();
            executorService2.awaitTermination(1, TimeUnit.MINUTES);
            long incrementerEnd = System.currentTimeMillis();

            incremented = incremented + (incrementerEnd - incrementerStart);
            System.out.println("Measure " + i + " complete and took " + (incrementerEnd - incrementerStart) + " ms");
        }

        System.out.println("AtomicLong 100M increments average time in 100 executions:  " + (incremented/10) + " ms");
        System.out.println("AtomicLong value is: " + atomicIncrementer.get());

        /**
         * Now trying to make a fixed number of increments to see how much time it takes with LongAdder
         */
        LongAdder longAdderIncrementer = new LongAdder();
        Runnable increment2 = () -> {
            long numIncrement = 10_000_000;
            for (int i = 0; i < numIncrement; i++) {
                longAdderIncrementer.increment();
            }
        };

        long incremented2 = 0;
        for (int k = 0; k < 10; k++) {
            ExecutorService executorService3 = Executors.newFixedThreadPool(10);
            long incrementerStart2 = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                executorService3.submit(increment2);
            }

            executorService3.shutdown();
            executorService3.awaitTermination(1, TimeUnit.MINUTES);
            long incrementerEnd2 = System.currentTimeMillis();

            incremented2 = incremented2 + (incrementerEnd2 - incrementerStart2);
            System.out.println("Measure " + k + " complete and took " + (incrementerEnd2-incrementerStart2) + " ms");
        }

        System.out.println("LongAdder 100M increments average time in 10 executions:  " + (incremented2/10) + " ms");
        System.out.println("LongAdder value is: " + longAdderIncrementer.longValue());

        LongAccumulator accumulator1 = new LongAccumulator((x, y)-> x + y, 0L);
        accumulator1.accumulate(4);
        assert accumulator1.get() == 4L;

        LongAccumulator accumulator2 = new LongAccumulator((x, y)-> x * y, 1L);
        accumulator2.accumulate(8);
        assert accumulator2.get() == 8L;
    }

}
