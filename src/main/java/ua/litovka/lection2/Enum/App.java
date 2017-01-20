package ua.litovka.lection2.Enum;

import ua.litovka.lection1.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SergLion on 13.01.2017.
 */
public class App {
    public static void main(String[] args) {

        Day myDayRead = Day.valueOf("SUNDAY");
        Day myDay = Day.SUNDAY;
        System.out.println(myDay.equals(myDayRead));

        System.out.println(Day.MONDAY.difDays(Day.SUNDAY));


        for (Day day : Day.values()) {

            System.out.println(day);
        }


        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Vasay", 25));
        humanList.add(new Human("Petay", 30));
        humanList.add(new Human("Petay", 56));
        humanList.add(new Human("Misha", 18));


        humanList.sort((o1, o2) -> {
            int result = o1.getName().compareTo(o2.getName());
            if (result == 0) {
                result = o1.getAge() - o2.getAge();
            }
            return result;
        });

        humanList.forEach(System.out::println);

    }

    public static enum Day {
        MONDAY(1, false),
        TUESDAY(2, false),
        SUNDAY(7, true);

        private int number;
        private boolean holiday;

        Day(int number, boolean holiday) {
            this.number = number;
            this.holiday = holiday;
        }

        public int getNumber() {
            return number;
        }

        public boolean isHoliday() {
            return holiday;
        }

        public void setHoliday(boolean holiday) {
            this.holiday = holiday;
        }

        public int difDays(Day day) {
            return Math.abs(getNumber() - day.getNumber());
        }
    }
}
