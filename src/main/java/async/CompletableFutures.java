package async;

import java.util.concurrent.*;

public class CompletableFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * Typical use with Futures
         */

//        Callable<Integer> callable = () -> {
//            int i = ThreadLocalRandom.current().nextInt(5, 10);
//            Thread.sleep(Math.abs(i)*1000);
//            return i;
//        };
//
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<Integer> result = executorService.submit(callable);
//        System.out.println("Result is: " + result.get());


        CompletableFuture<Integer> complFuture = CompletableFuture.supplyAsync(() -> {
            int i = ThreadLocalRandom.current().nextInt(5, 10);
            try {
                Thread.sleep(Math.abs(i) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        });
    }
}
