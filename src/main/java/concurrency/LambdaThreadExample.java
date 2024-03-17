package concurrency;

public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(()
                ->  System.out.println(Thread.currentThread().getName()+ " : Thread Running..."));
        thread.start();
    }
}
