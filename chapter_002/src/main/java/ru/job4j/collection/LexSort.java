package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        int leftInt = 0;
        int rightInt = 0;
        String[] leftInts = left.split("\\.");
        String[] rightInts = right.split("\\.");

        for (int i = 0; i < min; i++) {
            leftInt = Integer.parseInt(leftInts[i]);
            rightInt = Integer.parseInt(rightInts[i]);
            if (leftInt != rightInt) {
                return Integer.compare(leftInt, rightInt);
            }
        }
        return left.length() - right.length();
    }
}
