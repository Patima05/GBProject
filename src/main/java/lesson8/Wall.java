package lesson8;

public class Wall implements Obstacle {

    private int height;
    private String name = "wall";
    private String title;

    public Wall(String title, int height) {

        this.height = height;
        this.title = title;
    }

    @Override
    public String toString() {

        return title;
    }

    @Override
    public int getSize() {

        return height;
    }

    @Override
    public String getName() {
        return name;
    }

}
