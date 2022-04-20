package lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Road extends Stage{

    private CountDownLatch cdl;

    public Road(int length, CountDownLatch cdl) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        isTunnel = false;
        this.cdl = cdl;
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            cdl.countDown();
            if (cdl.getCount() == 3){
                System.out.println(c.getName() + " - WIN");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
