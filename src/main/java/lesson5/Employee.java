package lesson5;

import java.util.Scanner;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String surname, String patronymic, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return String.format("Имя: %s, фамилия: %s, отчество: %s, должность: %s, email: %s, телефон: %s, зарплата: %d, возраст: %d",
                name, surname, patronymic, position, email, phone, salary, age);
    }

    public boolean printInfoOver40YearsOld() {
        return this.age > 40;
    }

    public static int getValidNumber(Scanner in) {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                return n;
            } else {
                System.out.println("Неверный ввод данных! Повторный ввод:");
                in.next();
            }
        }
    }

}
