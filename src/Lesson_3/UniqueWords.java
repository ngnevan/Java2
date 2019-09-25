package Lesson_3;

import java.util.HashMap;

public class UniqueWords {
    public static void main(String[] args) {
        String[] strArr = {"Один", "Один", "Два", "Три", "Два", "Четыре", "Пять", "Шесть", "Один", "Два", "Один", "Три",
        "Два", "Четыре", "Шесть", "Один", "Два", "Два", "Четыре", "Шесть"};

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strArr.length ; i++) {
            Integer current = map.get(strArr[i]);
            map.put(strArr[i], current == null ? 1 : current + 1);
        }

        System.out.println(map);
    }
}
