package lesson10;

public class Apple extends Fruit{

    private static Integer numberOfApples = 0;
    private String title = "Яблоко";

    public Apple() {
        super(1.0);
        numberOfApples++;
        title += numberOfApples;
    }

    @Override
    public String toString() {
        return title;
    }

}
