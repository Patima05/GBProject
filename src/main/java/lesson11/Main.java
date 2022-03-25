package lesson11;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1:");
        testTask1();
        System.out.println("Задание 2:");
        testTask2();
    }

    private static void testTask1() {
        // 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести
        // список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.

        ArrayList<String> arrayOfWords = new ArrayList<>(10);
        Collections.addAll(arrayOfWords, "глобус", "карта", "планета", "Земля", "карта", "компас", "материк", "Земля", "Земля", "океан");

        Map<String, Integer> map = new HashMap<>();

        for (String s : arrayOfWords) {
            if (map.containsKey(s)){
                Integer value = map.get(s);
                map.put(s, ++value);
            } else {
                map.put(s, 1);
            }
        }

        System.out.println(map + "\n");
    }

    private static void testTask2() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Андреев", "+7-999-444-66-88");
        phoneBook.add("Меликов", "+7-499-454-67-87");
        phoneBook.add("Васильев", "+7-499-554-65-89");
        phoneBook.add("Андреев", "+7-429-449-69-89");
        phoneBook.add("Михайлов", "+7-499-484-66-48");
        phoneBook.print();

        System.out.println("Проверка метода get:");
        System.out.println(phoneBook.getPhones("Андреев"));
        System.out.println(phoneBook.getPhones("Тихонов"));

    }

}
