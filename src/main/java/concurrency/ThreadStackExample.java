package concurrency;

public class ThreadStackExample {
    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        private final int threadId;

        public MyRunnable(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run () {
            System.out.println(Thread.currentThread().getName()+ " : Thread Running...");
            firstMethod(threadId);
        }

        private void firstMethod(int threadId) {
            int localValue = threadId + 100;
            secondMethod(localValue);
        }
        private void secondMethod(int localValue) {
            String objectReference = threadId + ": Hello World";
            System.out.println(Thread.currentThread().getName()+ " : Thread ID : " + threadId + ", LocalValue :" + localValue);
        }
    }
}
