package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int n = 0; n < size; n++) {
                table[i][n] = (i + 1) * (n + 1);
            }
        }
        return table;
    }
}
