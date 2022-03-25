// 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
package lesson1;

public class Main {
    public static void main(String[] args) {
        // 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        int varA = 100000000; // целочисленный
        long varB = 180000000000L;
        double varC = 10.3;
        float varD = 10.3f;
        char с = 'c';
        String str = "string1";
        // проверка методов
        System.out.println(calcExpression(1, 2, 3, 4)); //2.75
        System.out.println(isBelongs(10, 5)); //true
        printIsPositive(6); //Число 6 положительное
        System.out.println(isNegative(-10)); //true
        printName("Игорь"); //Привет, Игорь!
        System.out.println(isLeapYear(2104)); //true
    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //        где a, b, c, d – аргументы этого метода, имеющие тип float.
    static float calcExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    static boolean isBelongs(int x, int y) {
        return ((x + y >= 10) && (x + y <= 20));
    }

    // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    // в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    static void printIsPositive(int val) {
        if (val >= 0) {
            System.out.println("Число " + val + " положительное");
        } else {
            System.out.println("Число " + val + " отрицательное");
        }
    }

    // 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    static boolean isNegative(int val) {
        return (val < 0);
    }

    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен
    // вывести в консоль сообщение «Привет, указанное_имя!».
    static void printName(String nm) {
        System.out.println("Привет, " + nm + "!");
    }

    // 8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
