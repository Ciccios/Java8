package atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongExample {


    public static void main(String[] args) {

        AtomicLong atomic = new AtomicLong();

        //Initial value of the atomic is 0 which will represent the previous value (x) and the update value 3 which will be the next value applied
        //to the function. In this specific case the result will be  9 = 0 + 3 * 3;
        long l = atomic.accumulateAndGet(3, (x, y) -> x + 3 * y);
        assert l == 9;

        //Here atomic hold the value 9 which will represent the previous value (x). The update value will be 2 and will be summed by the supplied
        //lambda to the previous value x which is currently 9. So 9 + 2 = 11
        //Return the old/current value before the accumulate function is applied
        long getAndAccumulate = atomic.getAndAccumulate(2, (x, y) -> x + y);

        //Make sure we've got the old value
        assert getAndAccumulate == 9;

        //Now let's see that is has the accumulated value
        assert atomic.get() == 11;


        /////////////////////////////////////////////////////

        long andUpdate = atomic.getAndUpdate(x -> x + 1);

        assert andUpdate == 11;
        assert atomic.get() == 12;


    }
}
