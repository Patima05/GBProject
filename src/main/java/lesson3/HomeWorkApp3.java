package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp3 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1. " + Arrays.toString(replaceArray(arr1)));
        System.out.println("2. " + Arrays.toString(fillArray100()));
        int[] arr2 = getArrayOfRandom(10);
        System.out.println("3. " + Arrays.toString(multiply2(arr2)));
        System.out.println("4. ");
        printSquareMatrix(fillArrayDiagonal(9), 9);
        System.out.println("5. " + Arrays.toString(initialArray(10, 5)));
        System.out.println("6. Введите элементы массива:");
        int[] arr3 = getArrFromScanner(12);
        System.out.println("max = " + findMinMax(1, arr3));
        System.out.printf("7. В массиве %s, в котором сумма левой и правой части массива равны \n",
                (isLeftRightEquals(arr3)) ? "есть место" : "нет места");

        System.out.println("8. Исходный массив:");
        System.out.println(Arrays.toString(arr3));
        int n = -66;
        System.out.printf("   Массив со сдвигом %s на %d позиций:\n",
                (n > 0) ? "вправо" : "влево", Math.abs(n));
        System.out.println(Arrays.toString(shiftN(n, arr3)));
    }

    /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
       [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1,
        1 на 0   */
    private static int[] replaceArray(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        return arr;
    }

    /* 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить
       его значениями 1 2 3 4 5 6 7 8 … 100  */
    private static int[] fillArray100() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
       и числа меньшие 6 умножить на 2  */
    private static int[] multiply2(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
       цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
       Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть
       [0][0], [1][1], [2][2], …, [n][n]  */
    private static int[][] fillArrayDiagonal(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                    arr[i][n - j - 1] = 1;
                }
            }
        }
        return arr;
    }

    /* вывод элементов квадратной матрицы arr размера n*n */
    private static void printSquareMatrix(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* создание массива случайных чисел размера n */
    private static int[] getArrayOfRandom(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(20) - 10; // (-10, 10)
        }
        return arr;
    }

    /* ввод элементов массива с клавиатуры  */
    private static int[] getArrFromScanner(int n) {
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            if (in.hasNextInt()) {
                arr[i] = in.nextInt();
                i++;
            } else {
                in.next();
            }
        }
        return arr;
    }

    /* создание массива целых чисел размера n и ввод с клавиатуры */
    private static int[] createInputArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            in.close();
        }
        return arr;
    }

    /* 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа
    int длиной len, каждая ячейка которого равна initialValue  */
    private static int[] initialArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /* 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы  */
    private static int findMinMax(int minOrMax, int... arr) {  //minOrMax
        int min = Integer.MAX_VALUE; // макс. зн-е типа int
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        if (minOrMax == 0) // если minOrMax = 0, тогда возврат min
            return min;
        else return max; // в противном случае возврат max
    }

    /* 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
       если в массиве есть место, в котором сумма левой и правой части массива равны. */
    private static boolean isLeftRightEquals(int... arr) {
        boolean isEquals = false;
        int leftSum = arr[0];
        int rightSum = 0;
        // вычисляем сумму справа
        for (int i = 1; i < arr.length; i++) {
            rightSum += arr[i];
        }
        int i = 0;
        // пока не найдены равные суммы слева и справа от элемента под номером i
        while (!isEquals && i < arr.length - 1) {
            if (leftSum == rightSum) {  //если равные суммы найдены, тогда
                isEquals = true;
            } else { // иначе переходим к следующему элементу, добавляем его в сумму справа и вычитываем из суммы слева
                i++;
                leftSum += arr[i];
                rightSum -= arr[i];
            }
        }
        return isEquals;
    }

    /* 8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
       отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
       Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
       (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую
       сторону сдвиг можете выбирать сами. */

    private static int[] shiftN(int n, int[] arr) {
        if (n > 0) {   //сдвиг вправо
            while (n > arr.length) n -= arr.length;
            for (int k = 0; k < n; k++) {
                int temp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = temp;
            }
        } else {   // сдвиг влево
            while (n < -arr.length) n += arr.length;
            for (int k = 0; k < Math.abs(n); k++) {
                int temp = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = temp;
            }
        }
        return arr;
    }
}