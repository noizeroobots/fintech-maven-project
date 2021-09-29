package ru.tinkoff;

public class Student {

    private final String name;
    private int age;
    private int id;

    public Student(final String name, final int age, final int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ']';
    }
}


