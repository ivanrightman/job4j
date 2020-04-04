package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("pochta@mail.ru", "Pochotvik Pochtiy Pochtovich");

        for (String key : hmap.keySet()) {
            String value = hmap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
