package ua.litovka.lection4;

/**
 * Created by SergLion on 23.01.2017.
 */
public class Student <T, S extends Number> {
    private String name;
    private T sex;
    private S age;

    public void becameOlder(int year) {
        age = (S) Integer.valueOf(age.intValue() + year);
    }

    public Student(String name, T sex, S age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getSex() {
        return sex;
    }

    public void setSex(T sex) {
        this.sex = sex;
    }

    public S getAge() {
        return age;
    }

    public void setAge(S age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
