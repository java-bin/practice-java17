package concurrency;

import java.util.ArrayList;
import java.util.List;

// ParallelismExample / ConcurrencyExample
// 하나가 동시에 작업을 왔다갔다 하는 것을 의미
public class ConcurrencyExample {
    public static void main(String[] args) {

        // available CPU *2
//        int cpuCores = Runtime.getRuntime().availableProcessors() * 2;
        int cpuCores = 13;

        // CPU 2배 초과 개수만큼 데이터를 생성한다
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
