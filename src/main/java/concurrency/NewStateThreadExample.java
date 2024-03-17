package concurrency;

public class NewStateThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running...");
            }
        });
        System.out.println("thread.getState() = " + thread.getState());
                
    }
}
