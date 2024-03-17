package concurrency;

// ExtendThreadExample / ImplementRunnableExample
// Thread 클래스를 상속하여 사용하는 방법
public class ExtendThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : Thread Running...");
    }

}
