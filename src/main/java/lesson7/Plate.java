package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return n;
        }
        else {
            int temp = food;
            food = 0;
            return temp;
        }
    }

    public void info() {
        System.out.println("На тарелке: " + food);

    }

    public void addFood(int food){
        this.food += food;
    }
}