package lesson10;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        Box <Apple> applesBox = new Box <>(10);

        applesBox.add(apple1);
        applesBox.add(apple2);
        applesBox.add(apple3);
        applesBox.add(apple4);

        //метод getWeight()
        applesBox.printContent();
        System.out.println("Вес коробки: " + applesBox.getWeight());

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();

        Box <Orange> orangesBox = new Box <>(10);

        orangesBox.add(orange1);
        orangesBox.add(orange2);
        orangesBox.add(orange3);
        orangesBox.add(orange4);
        orangesBox.add(orange5);

        Box <Orange> orangesBox2 = new Box <>(10);

        orangesBox2.add(orange1);
        orangesBox2.add(orange2);
        orangesBox2.add(orange3);
        orangesBox2.add(orange4);
        orangesBox2.add(orange5);

        // метод compare
        if (orangesBox.compare(orangesBox2)) {
            System.out.println("Коробки равны по весу!");
        } else {
            System.out.println("У коробок разный вес");
        }

        // метод poor - пересыпать
        orangesBox.poor(orangesBox2);
        orangesBox.printContent();
        orangesBox2.printContent();
        orangesBox2.poor(orangesBox);
        orangesBox.printContent();
        orangesBox2.printContent();

    }
}
