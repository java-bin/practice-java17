package threadstate;

public class ThreadLifecycleExample {

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(() -> {});
        System.out.println("스레드 생성: " + newThread.getState());

        Thread runnableThread = new Thread(() -> {
            while(true) {

            }
        });
        runnableThread.start();

        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        timedWaitingThread.start();
        Thread.sleep(100);

        final Object lock = new Object();
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        waitingThread.start();
        Thread.sleep(100);

        Thread runningThread = new Thread(() -> {
            synchronized (lock) {
                while (true) {

                }
            }
        });
        runningThread.start();
        Thread.sleep(100);
        Thread blockedThread = new Thread(() -> {
            synchronized (lock) {
            }
        });
        blockedThread.start();
        Thread.sleep(100);

        newThread.start();
        newThread.join();

        System.out.println("스레드 실행: " + runnableThread.getState());
        System.out.println("스레드 지정된 시간 대기: " + timedWaitingThread.getState());
        System.out.println("스레드 대기: " + waitingThread.getState());
        System.out.println("스레드 차단: " + blockedThread.getState());
        System.out.println("스레드 종료: " + newThread.getState());
    }
}
