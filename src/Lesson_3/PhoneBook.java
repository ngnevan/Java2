package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> map;

    public PhoneBook() {
        map = new HashMap<>();
    }

    public String[] get(String name) {
        ArrayList<String> al = map.get(name);
        if (al == null)
            return null;
        else {
            String[] strArr = al.toArray(new String[al.size()]);
            return strArr;
        }

    }

    public void add(String name, String phone) {
        ArrayList<String> al = map.get(name);
        if (al == null) {
            al = new ArrayList<>();
        }
        al.add(phone);
        map.put(name, al);
    }

    public void info() {
        for (Map.Entry<String, ArrayList<String>> o : map.entrySet()) {
            System.out.println(o.getKey() + " " + o.getValue());
        }
    }
}

class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Ivanov", "11111");
        phonebook.add("Petrov", "22222");
        phonebook.add("Sidorov", "33333");
        phonebook.add("Ivanov","11112");
        phonebook.add("Petrov", "22223");
        phonebook.add("Petrov", "22224");

        phonebook.info();
        String[] strArr = phonebook.get("Petrov");
        System.out.print("Petrov: ");
        for (int i = 0; i < strArr.length ; i++) {
            System.out.print(strArr[i] + " ");
        }

    }
}