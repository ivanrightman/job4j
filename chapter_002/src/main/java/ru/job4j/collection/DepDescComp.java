package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        //char[] leftCh = left.toCharArray();
        //char[] rightCh = right.toCharArray();
        int equation = 0;
        int slashCount = 0;
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) == right.charAt(i)) {
                equation++;
            }
            if (left.charAt(i) == 47 && right.charAt(i) == 47) { // 47 это "/"
                slashCount++;
            }
            if (left.charAt(i) != right.charAt(i)) {
                if (equation == min - 1 && slashCount > 0) {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
                return Character.compare(right.charAt(i), left.charAt(i));
            }
        }
        return left.length() - right.length();
    }
}
