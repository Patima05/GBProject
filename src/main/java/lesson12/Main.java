package lesson12;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        long time = runInSingleTread();
        System.out.println("Время, затраченное на выполнение в одном потоке: " + time);

        time = runInTwoTreads();
        System.out.println("Время, затраченное на выполнение в двух потоках: " + time);

    }

    public static void f(float[] arr, long n) {
        for (int i = 0; i < n; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void f2(float[] arr, long n) {
        for (int i = 0; i < n; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + 2 * n / 5) * Math.cos(0.2f + 2 * n / 5) * Math.cos(0.4f + 2 * n / 2));
        }
    }

    private static long runInSingleTread() {
        float[] arr = new float[SIZE];
        for (float x : arr) {
            x = 1;
        }
        long a = System.currentTimeMillis();
        f(arr, SIZE);
        return System.currentTimeMillis() - a;
    }

    private static long runInTwoTreads() {
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (float x : arr1) {
            x = 1;
        }
        for (float x : arr2) {
            x = 1;
        }

        var thread1 = new Thread(() -> Main.f(arr1, HALF));
        var thread2 = new Thread(() -> Main.f2(arr2, HALF));

        long a = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - a;

    }


}
