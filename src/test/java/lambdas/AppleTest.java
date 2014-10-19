package lambdas;

import org.junit.Test;

public class AppleTest {

    @Test
    public void testCapturedLambdas() {

        int port = 8080;
        //port = 3; //Un commenting this line will cause compilation error
        Runnable r = () -> System.out.println(port);
    }

}