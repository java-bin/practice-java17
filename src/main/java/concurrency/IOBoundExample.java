package concurrency;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CPUBoundExample / IOBoundExample
public class IOBoundExample {
    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors() * 2;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                try {
                    // IO가 집중되는 작업
                    for (int j = 0; j < 5; j++) {
                        Files.readAllLines(Path.of("/Users/chaebin/IdeaProjects/practice/practice-java17/src/main/java/concurrency/sample.txt"));
                        // IO Bound 일 때, ContextSwitching
                        System.out.println("Thread: " + Thread.currentThread().getName() + ", " + j);
                    }

                    // CPU 연산
                    int result = 0;
                    for (long j = 0; j < 10; j++) {
                        result += j;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
