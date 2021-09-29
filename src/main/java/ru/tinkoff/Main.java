package ru.tinkoff;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


        private static final ArrayList<Student> STUDENTS = new ArrayList<>(){{
            add(new Student("Николай", 68, 100));
            add(new Student("Пётр", 53, 101));
            add(new Student("Василий", 25, 102));
            add(new Student("Михаил", 19, 103));
            add(new Student("Алексей", 6, 104));
            add(new Student("Николай", 86, 105));
            add(new Student("Пётр", 35, 106));
            add(new Student("Михаил", 111, 107));
            add(new Student("Алексей", 22, 108));
            add(new Student("Михаил", 1, 109));
            add(new Student("Яков", 30, 110));
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

    }
}
