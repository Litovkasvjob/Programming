package ua.litovka.lection2.junit;

/**
 * Created by SergLion on 13.01.2017.
 */
public class Calculator {

    public int sum(int a, int b) {
        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    public int divide(int a, int b) {

        return a / b;
    }


}
