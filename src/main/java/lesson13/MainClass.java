package lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static boolean is_begin = false;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT * 2);
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

        Race race = new Race(new Road(60, cdl2), new Tunnel(semaphore), new Road(40, cdl2));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdl.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdl2.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");



    }
}
/*
1. Перенести приведенный ниже код в новый проект, где мы организуем гонки.
        Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не
        может одновременно заехать больше половины участников (условность).
        Попробуйте все это синхронизировать.
        Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения
        этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями
        недопустима).
        Когда все завершат гонку, нужно выдать объявление об окончании.
        Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
        пакета java.util.concurrent.
 */