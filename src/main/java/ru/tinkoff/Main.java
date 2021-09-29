package ru.tinkoff;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


        private static final ArrayList<Student> STUDENTS = new ArrayList<>(){{
            add(new Student("Николай", 68, 2021000));
            add(new Student("Пётр", 53, 2021001));
            add(new Student("Василий", 25, 2021002));
            add(new Student("Михаил", 19, 2021003));
            add(new Student("Алексей", 6, 2021004));
            add(new Student("Николай", 86, 2021005));
            add(new Student("Пётр", 35, 2021006));
            add(new Student("Михаил", 111, 2021007));
            add(new Student("Алексей", 22, 2021008));
            add(new Student("Михаил", 1, 2021009));
            add(new Student("Яков", 30, 2021010));
        }};

    public static void main(String[] args) {

        String chosenName = "Алексей";
        int chosenAge = 112;

// Рассчёт суммарного возраста для определённого имени.
        List<Student> simultaneousNames = STUDENTS
                .stream()
                .filter(student -> student.getName().equals(chosenName))
                .collect(Collectors.toList());

            int sum = simultaneousNames.stream()
                    .mapToInt(Student::getAge)
                    .sum();

            System.out.println("Суммарный возраст для имени \"" + chosenName + "\": " + sum);

// Получить SET, который содержит в себе только имена учеников.
// После преобразования все дублированные значения в List будут просто игнорироваться,
// потому что Set не допускает дублирование значений.
        List<String> listOfAllNames = STUDENTS
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());

        Set<String> set = new HashSet<String>(listOfAllNames);
        System.out.print("SET имён учеников: ");
            for (String name : set){
                        System.out.print(name + " ");
            }

// Узнать, содержит ли список хотя бы одного ученика,
// у которого возраст больше заданного числа.
        List<Student> overChosenAge = STUDENTS
                .stream()
                .filter(student -> student.getAge() > chosenAge)
                .collect(Collectors.toList());
            if (overChosenAge.size() >= 1) {
                System.out.println("\nСписок содержит учеников, у которых возраст больше " + chosenAge);
            } else {
                System.out.println("\nСписок не содержит учеников, у которых возраст больше " + chosenAge);
            }

// Преобразовать список в Map, у которой ключ: ID, значение: name.
    Map<Integer, String> mapped = STUDENTS
        .stream()
        .collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println("Собранный Map по условию ключ: ID и значение: Name:");
        mapped.forEach((k, v) -> System.out.println("ID: " + k + " => " + "Name: " + v));


// Преобразовать список в Map, у которой ключ: Age, значение: object.
        Map<Integer, Student> mapped1 = STUDENTS
                .stream()
                .collect(Collectors.toMap(Student::getAge, student -> student));
        System.out.println("Собранный Map по условию ключ: Age и значение: Object:");
        mapped1.forEach((k, v) -> System.out.println("Age: " + k + " => " + v));


    }
}
