package lesson7;

public class Cat {

    private String name;
    private int appetite;
    private int satiety;

    public void printIsSatiety() {
        if (appetite == satiety) {
            System.out.println("Кот " + name + " сыт!");
        }
        else {
            if (satiety == 0){
                System.out.println("Кот " + name + " голоден!");
            }
            else {
                System.out.println("Кот " + name + " не наелся!");

            }
        }
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = 0;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

}
