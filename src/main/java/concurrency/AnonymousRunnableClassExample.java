package concurrency;

public class AnonymousRunnableClassExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " : Thread Running...");
            }
        });
        thread.start();
    }
}
