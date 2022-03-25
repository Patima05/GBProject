package lesson11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    //   2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с
    //   помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
    //   может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
    private Map<String, Set<String>> phoneList;

    public PhoneBook() {
        phoneList = new HashMap<>();
    }

    public void add(String surname, String phone) {
        Set<String> phones = phoneList.getOrDefault(surname, new HashSet<>());
        phones.add(phone);
        phoneList.put(surname, phones);
    }

    public Set<String> getPhones(String surname) {

        Set<String> phones = phoneList.getOrDefault(surname, new HashSet<>());
        return phones;
    }

    public void print() {
        for (String key : phoneList.keySet()) {
            System.out.println(key);
            Set<String> phones = phoneList.get(key);
            phones.forEach(s -> System.out.println("\t\t" + s));
        }

    }
}
