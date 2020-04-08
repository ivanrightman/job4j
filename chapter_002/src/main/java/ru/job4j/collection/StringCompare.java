package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {

/*
String.charAt(int index)
Integer.compare(int left, int right),
Character.compare(char left, char right);
*/

    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return left.length() - right.length();
    }
}
