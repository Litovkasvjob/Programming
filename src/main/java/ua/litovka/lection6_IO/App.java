package ua.litovka.lection6_IO;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by SergLion on 01.02.2017.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(readFile("src/main/resources/text", "utf-8"));
        textWriter("Hello world","src/main/resources/text" );
        TreeSet<String> stringTreeSet = new TreeSet<>(String::compareToIgnoreCase);

        try (Scanner scanner = new Scanner(new FileInputStream("src/main/resources/text"), "utf-8")) {
            scanner.useDelimiter("\\W+");
            while (scanner.hasNext()) {
                stringTreeSet.add(scanner.next());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       stringTreeSet.forEach(System.out::println);

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("hj"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String readFile(String path, String charset) {

        char[] buf = new char[10];
        StringBuilder sb = new StringBuilder();
int count = 0;
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), charset)) {

            while ((count = inputStreamReader.read(buf)) != -1) {
                sb.append(new String(buf, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }

    public static void textWriter(String text, String path) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String from, String to) {
        byte[] buf = new byte[1024];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to))){
            while (bis.read(buf) != -1) {
                bos.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
