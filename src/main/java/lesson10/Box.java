package lesson10;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> data;
    private static final int DEFAULT_SIZE = 16;

    public Box(int size) {
        this.data = new ArrayList<>(size);
    }

    public void add(E e) {
        data.add(e);
    }

    public double getWeight() {
        return data.size() * data.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void exchange(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public void poor(Box<E> box) {
        box.data.addAll(this.data);
        this.data.clear();
    }

    public void printContent() {
        System.out.println("Содержимое коробки:");
        if (data.isEmpty()) {
            System.out.println("коробка пуста!");
        } else {
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }

    }

}
