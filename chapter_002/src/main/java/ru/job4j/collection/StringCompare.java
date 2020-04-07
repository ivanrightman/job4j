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
        char[] fromLeftChars = left.toCharArray();
        char[] fromRightChars = right.toCharArray();
        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if (fromLeftChars[i] != fromRightChars[i]) {
                return Character.compare(fromLeftChars[i], fromRightChars[i]);
            }
        }
        return left.length() - right.length();
    }
}
