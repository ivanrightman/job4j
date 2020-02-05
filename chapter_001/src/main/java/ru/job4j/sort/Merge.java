package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        int n = 0;
        int o = 0;
        while (i < left.length && n < right.length) {
            if (left[i] < right[n]) {
                rsl[o++] = left[i++];
            } else {
                rsl[o++] = right[n++];
            }
        }
        while (i < left.length) {
            rsl[o++] = left[i++];
        }
        while (n < right.length) {
            rsl[o++] = right[n++];
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
