import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {
    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        Future future = exe.submit(new Callable<Object>() {

            public Object call() throws Exception {
                System.out.println("retriving data...");
                Thread.sleep(5000);
                return "good";
            }
        });

        System.out.println("get data : " + future.get());
    }
}
