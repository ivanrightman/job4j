package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftInt;
        int rightInt;
        String[] leftInts = left.split("\\.");
        String[] rightInts = right.split("\\.");

        leftInt = Integer.parseInt(leftInts[0]);
        rightInt = Integer.parseInt(rightInts[0]);
        if (leftInt != rightInt) {
            return Integer.compare(leftInt, rightInt);
        }
        return left.length() - right.length();
    }
}
