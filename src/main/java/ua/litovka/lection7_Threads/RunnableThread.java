package ua.litovka.lection7_Threads;

/**
 * Created by SergLion on 06.02.2017.
 */
public class RunnableThread implements Runnable {


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("start" + thread.getName());
        for (int i = 0; i < 20; i++) {
            System.out.print("+");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end" + thread.getName());


    }
}
