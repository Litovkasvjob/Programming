package ua.litovka.lection7_Threads;

/**
 * Created by SergLion on 06.02.2017.
 */
public class App {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(new RunnableThread());
        myThread.start();
        thread.start();
        System.out.println(Thread.currentThread().getName() + "end");

        new Thread(()->{
            Thread thread2 = Thread.currentThread();
            System.out.println("start " + thread2);
            for (int i = 0; i < 20; i++) {
                System.out.print("//");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end" + thread2);
        }).start();

        AutoThread autoThread = new AutoThread("Rety");
    }
}
