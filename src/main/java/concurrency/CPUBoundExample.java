package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// CPUBoundExample / IOBoundExample
public class CPUBoundExample {
    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        long startTime = System.currentTimeMillis();
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Future<?> future = executorService.submit(() -> {

                // CPU 연산이 집중되고 오래 걸리는 작업
                long result = 0;
                for (long j = 0; j < 10000000000L; j++) {
                    result += j;
                }

                // a little wait
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // CPU Bound 일 때 ContextSwithing
                System.out.println("Thread: " + Thread.currentThread().getName() + ", " + result);
            });
            futures.add(future);
        }
        long endTIme = System.currentTimeMillis();
        System.out.println("CPU 개수를 초과하는 데이터를 병렬로 처리하는 데 걸리는 시간: " + (endTIme - startTime) + "ms");
        executorService.shutdown();
    }
}
