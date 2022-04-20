package lesson13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public abstract class Stage{
    protected int length;
    protected String description;
    protected boolean isTunnel;
    public boolean isTunnel() {
        return isTunnel;
    }

    public abstract void go(Car c);
}
