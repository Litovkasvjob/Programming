package ua.litovka.lection7_Threads;

/**
 * Created by SergLion on 06.02.2017.
 */
public class AutoThread implements Runnable {

    Thread thread;


    public AutoThread(String name) {
        thread = new Thread(this, name);
        thread.start();

    }
    @Override
    public void run() {
        System.out.println(thread);
    }
}
