package threadstate;

public class TerminatedStateTHreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Running...");
            }
        });
        thread.start();
        thread.join();
        System.out.println("thread.getState() = " + thread.getState());
    }
}
