package lesson6;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Мурка");
        Dog dog1 = new Dog("Шарик");

        cat1.run(50);
        cat1.swim(10);

        dog1.run(600);
        dog1.swim(5);

        System.out.println("Всего " + Animal.getNumberOfAnimals() + " животных.");

    }
}
