package ru.job4j.ex;

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int i = 0;
        for (int index = names.length - 1; index > 0; index--) {
            String temp = names[i];
            names[i] = names[index];
            names[index] = temp;
            i++;
            if (i == names.length / 2) {
                break;
            }
        }
        System.out.println(Arrays.toString(names));
    }
}
