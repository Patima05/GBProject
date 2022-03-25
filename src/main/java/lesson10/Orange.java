package lesson10;

public class Orange extends Fruit{

    private static Integer numberOfOranges = 0;
    private String title = "Апельсин";

    public Orange() {
        super(1.5);
        numberOfOranges++;
        title += numberOfOranges;
    }

    @Override
    public String toString() {
        return title;
    }
}
