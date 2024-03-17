package threadstate;

public class RunnableStateThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 1000000000; i++) {
                        if (i % 1000000000 == 0) {
                            System.out.println("thread.getState() = " + Thread.currentThread().getState());
                        }
                    }
                }
            }
        });
        thread.start();

    }
}
