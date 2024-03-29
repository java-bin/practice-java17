package concurrency;

public class AnonymousThreadClassExample {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " : Thread Running...");
            }
        };
        thread.start();
    }
}
