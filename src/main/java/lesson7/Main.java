package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 15), new Cat("Tishka", 20), new Cat("Gav", 10)};

        Plate plate = new Plate(40);

        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].printIsSatiety();
        }
        plate.info();

        plate.addFood(20);
        plate.info();
    }
}