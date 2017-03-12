package ua.litovka.lection4;

import ua.litovka.lection1.Human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SergLion on 23.01.2017.
 */
public class App {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("VAsya");
        arrayList.add(new Human("Vasya", 25));

        if (arrayList.get(1) instanceof String) {
            System.out.println(((String) arrayList.get(1)).length());
        }

        Student<Sex, Number> student = new Student<>("Vasya", Sex.MALE, 25);
        System.out.println(student);

        Student<Character, Double> student1 = new Student<>("Masha", 'F', 18.0);
        System.out.println(student1);

        List<Student<Sex, Number>> studentList = new ArrayList<>();

        studentList.add(student);
//        studentList.add(student1);
        studentList.add(new Student<>("Vasya", Sex.MALE, 25));

        Student<Sex, Number>[] students = new Student[2];
        students[0] = student;
        students[1] = new Student<>("Kate", Sex.FEMALE, 18);

        App.printArray(students);
        System.out.println("------------------------");

        List<Student<?, ? super Number>> studentList1 = new ArrayList<>();

        System.out.println(student);
        student.becameOlder(2);
        System.out.println(student);

        Comparator<Student<Sex, Number>> studentComparator = new Comparator<Student<Sex, Number>>() {
            @Override
            public int compare(Student<Sex, Number> o1, Student<Sex, Number> o2) {
                return o1.getAge().intValue() - o2.getAge().intValue();
            }
        };

        System.out.println(studentComparator.getClass().getName());

        Comparator<Student<Sex, Number>> studentLyamda = (o1, o2) -> o1.getAge().intValue() - o2.getAge().intValue();
        System.out.println(studentLyamda.getClass().getName());


        System.out.println(sum(2, 3 , 4, 5.6, 7.34, new Integer(32)));


        printStudentName(student, student1);

        B<Integer, Double> b = new B<>();
    }

    public static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T extends Number> double sum(T... numbers) {
        double sum = 0;

        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void printStudentName(Student<?, ? extends Number>... students) {
        for (Student<?, ? extends Number> student : students) {
            System.out.println(student.getName());
        }
    }
}


class A<T> {
    private T age;
    private String name;

    public T getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class B<T, S> extends A<T> {
    private S size;

    public S getSize() {
        return size;
    }
}
