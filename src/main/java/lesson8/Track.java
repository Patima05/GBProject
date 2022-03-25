package lesson8;

public class Track implements Obstacle{

    private int width;
    private String title;
    private String name = "track";


    public Track(String title, int width) {

        this.title = title;
        this.width = width;
    }

    @Override
    public String toString() {

        return title;
    }

    @Override
    public int getSize() {

        return width;
    }

    @Override
    public String getName() {
        return name;
    }

}
