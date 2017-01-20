package ua.litovka.lection2.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by SergLion on 13.01.2017.
 */
public class App {
    public static void main(String[] args) {

        B b = new B();
        //b.read("Hell");

    }

}

class A {
    public String read(String path) {
        Scanner scanner = new Scanner(path);
        return scanner.nextLine();
    }
}

class B extends A {

    @Override
    public String read(String path) {
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            result = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);

        }
        return result;
    }
}
