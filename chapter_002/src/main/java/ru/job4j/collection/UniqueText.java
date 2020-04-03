package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        int containsCount = 0;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String el : origin) {
            check.add(el);
        }
        for (String el : text) {
            if (check.contains(el)) {
                containsCount++;
            }
            if (containsCount == check.size()) {
                rsl = true;
            }
        }
        return rsl;
    }
}
