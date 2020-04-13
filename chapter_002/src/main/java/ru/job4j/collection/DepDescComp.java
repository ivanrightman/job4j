package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] fromLeft = left.split("/");
        String[] fromRight = right.split("/");
        int result;
        result = fromRight[0].compareTo(fromLeft[0]);
        if (result == 0) {
            result = left.compareTo(right);
        }
        return result;
    }
}