package ua.litovka.lection7_Threads;

/**
 * Created by SergLion on 06.02.2017.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("start" + getName());
        for (int i = 0; i < 20; i++) {
            System.out.print(".");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end" + getName());
    }
}
