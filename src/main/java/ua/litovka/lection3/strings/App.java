package ua.litovka.lection3.strings;

import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by SergLion on 18.01.2017.
 */
public class App {
    public static void main(String[] args) {
        int i = Integer.parseInt("41", 16);
        Integer integer = Integer.valueOf("23");
        System.out.println(i);

        String s = "mam mila ramu";
        System.out.println(s.startsWith("mam"));
        System.out.println(s.endsWith("mam"));
        System.out.println(s.startsWith("mam", 3));

        String s1 = "mama";
        String s2 = "papa";

        System.out.println(s1.compareTo(s2));

//        s1.matches("");
        String s3 = "mama - papa ? , , i !! docha";
        StringTokenizer stringTokenizer = new StringTokenizer(s3, " ,?!-");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        String s4 = "2.4; 3.5; 6.7 ";
        Scanner sc = new Scanner(s4).useDelimiter("[; ]+").useLocale(Locale.ENGLISH);
        double sum = 0;
        while (sc.hasNextDouble()) {
            sum += sc.nextDouble();

        }
        System.out.println(sum);

        sum = 0;
        for (String s5 : s4.split("[; ]+")) {
            sum += Double.parseDouble(s5);
        }
        System.out.println(sum);
    }
}
