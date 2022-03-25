package lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(isBelongs(6, 4));
        printIsPositiveOrNegative(-10);
        System.out.println(isNegative(-10));
        printStringN("Солнце", 5);
        System.out.println(isLeapYear(2022));
    }

    /* 1. Написать метод, принимающий на вход 2 целых числа и проверяющий, что
       сумма лежит в пределах от 10 до 20 (включительно), если да - вернуть true,
       в противном случае - false  */
    static boolean isBelongs(int x, int y) {
        return ((x + y >= 10) && (x + y <= 20));
    }

    /* 2. Написать метод, которому в качестве параметра передается целое число,
       метод должен напечатать в консоль, положительное ли число передали или
       отрицательное. Замечание: ноль считаем положительным числом. */
    static void printIsPositiveOrNegative(int val) {
        if (val >= 0) {
            System.out.println("Число " + val + " положительное");
        } else {
            System.out.println("Число " + val + " отрицательное");
        }
    }

    /* 3. Написать метод, которому в качестве параметра передается целое число,
       метод должен вернуть true, если число отрицательное, и вернуть false если
       положительное. */
    static boolean isNegative(int val) {
        return (val < 0);
    }

    /* 4. Написать метод, которому в качестве аргументов передается строка и число,
       метод должен отпечатать в консоль указанную строку, указанное количество раз. */
    static void printStringN(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    /* 5. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
       Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
    static boolean isLeapYear(int year) {

        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
