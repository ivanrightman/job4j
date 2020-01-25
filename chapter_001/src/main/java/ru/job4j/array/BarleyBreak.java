package ru.job4j.array;

import java.util.Arrays;

public class BarleyBreak {
    public static void main(String[] args) {
        int[][] table = new int[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {
                table[i][n] = k;
                k++;
            }
        }
        System.out.println(Arrays.deepToString(table));
    }
}
