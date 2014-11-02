package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class AddersAndAccumulators {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Using long adder for less contention and see how many increments we get after 10 seconds
         */
        LongAdder longAdder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println("Starting Threads for long adder ... ");
        Runnable adder = () -> {
            long current = System.currentTimeMillis();
            long end = current + 10000;
            while (System.currentTimeMillis() < end) {
                longAdder.increment();
            }
        };

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService.execute(adder);
        }
        executorService.shutdown();
        executorService.awaitTermination(15, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis();
        long sum = longAdder.sum();
        System.out.println("Time elapsed: " + (endTime - start));
        System.out.println("Sum: " + sum);

        /**
         * Using Atomic Long to see how many increments we get after 10 seconds
         */
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        AtomicLong atomicLong = new AtomicLong();
        Runnable atomic = () -> {
            long current = System.currentTimeMillis();
            long end = current + 10000;
            while (System.currentTimeMillis() < end) {
                atomicLong.incrementAndGet();
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService1.submit(atomic);
        }
        executorService1.shutdown();
        executorService1.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("Sum: " + atomicLong.get());


        /**
         * Now trying to make a fixed number of increments to see how much time it takes with AtomicLong
         */

        AtomicLong atomicIncrementer = new AtomicLong();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        Runnable increment = () -> {
            long numIncrement = 10_000_000;
            for (int i = 0; i < numIncrement; i++) {
                atomicIncrementer.incrementAndGet();
            }
        };

        long incrementerStart = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService2.submit(increment);
        }

        executorService2.shutdown();
        executorService2.awaitTermination(1, TimeUnit.MINUTES);
        long incrementerEnd = System.currentTimeMillis();

        System.out.println("AtomicLong 100M increments took:  " + (incrementerEnd - incrementerStart) + " ms");
        System.out.println("AtomicLong value is: " + atomicIncrementer.get());

        /**
         * Now trying to make a fixed number of increments to see how much time it takes with LongAdder
         */
        LongAdder longAdderIncrementer = new LongAdder();
        ExecutorService executorService3 = Executors.newFixedThreadPool(10);
        Runnable increment2 = () -> {
            long numIncrement = 10_000_000;
            for (int i = 0; i < numIncrement; i++) {
                longAdderIncrementer.increment();
            }
        };

        long incrementerStart2 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService3.submit(increment2);
        }

        executorService3.shutdown();
        executorService3.awaitTermination(1, TimeUnit.MINUTES);
        long incrementerEnd2 = System.currentTimeMillis();

        System.out.println("LongAdder 100M increments took:  " + (incrementerEnd2 - incrementerStart2) + " ms");
        System.out.println("LongAdder value is: " + longAdderIncrementer.longValue());
    }

}
