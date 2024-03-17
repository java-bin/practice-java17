package concurrency;

import java.util.ArrayList;
import java.util.List;

// ParallelismExample / ConcurrencyExample
//  여러개의 CPU가 병렬적으로 작업함을 의미
public class ParallelismExample {
    public static void main(String[] args) {

        // available CPU
        int cpuCores = Runtime.getRuntime().availableProcessors();

        // CPU 개수만큼 데이터를 생성한다
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < cpuCores; i++) {
            data.add(i);
        }

        // CPU 개수만큼 병렬로 처리
        long startTime = System.currentTimeMillis();

        long sum = data.parallelStream()
//        long sum = data.stream()
                .mapToLong(i -> {
                    try {
                        Thread.sleep(500); // 0.5s
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * i;
                })
                .sum();

        long endTime = System.currentTimeMillis();

        System.out.println("CPU parallel Time= " + (endTime - startTime) + "ms");
        System.out.println("sum= " + sum);
    }
}
