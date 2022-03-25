package lesson5;

import java.util.Scanner;

public class HomeWork5 {
    private static final Integer NUMBEROFEMPLOYEES = 5;

    public static void main(String[] args) {
        Employee[] employees = new Employee[NUMBEROFEMPLOYEES];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите информацию о сотрудниках");
        for (int i = 0; i < NUMBEROFEMPLOYEES; i++) {
            System.out.printf("Cотрудник %d:\n", i + 1);
            System.out.println("имя:");
            String name = in.next();
            System.out.println("фамилия:");
            String surname = in.next();
            System.out.println("отчество:");
            String patronymic = in.next();
            System.out.println("должность:");
            String position = in.next();
            System.out.println("email:");
            String email = in.next();
            System.out.println("номер телефона:");
            String phone = in.next();
            System.out.println("размер зп:");
            int salary = Employee.getValidNumber(in);
            System.out.println("возраст:");
            int age = Employee.getValidNumber(in);
            employees[i] = new Employee(name, surname, patronymic, position, email, phone, salary, age);
        }
        in.close();
        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < NUMBEROFEMPLOYEES; i++) {
            employees[i].printInfoOver40YearsOld();
        }


    }
}
