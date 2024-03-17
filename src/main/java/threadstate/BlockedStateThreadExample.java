package threadstate;

public class BlockedStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while(true) {

                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while(true) {
                        System.out.println("i want lock");
                    }
                }
            }
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        System.out.println("thread1.getState() = " + thread1.getState());
        System.out.println("thread2.getState() = " + thread2.getState());
    }
}
