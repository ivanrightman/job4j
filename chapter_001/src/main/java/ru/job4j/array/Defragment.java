package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        String tmp;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                int point = 1;
                while (array[index] == null) {
                    tmp = array[index];
                    if (index+point >= array.length) {
                        break;
                    }
                    array[index] = array[index+point];
                    array[index+point] = tmp;
                    point++;
                }
            }
            System.out.println(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.println(compressed[index] + " ");
        }
    }
}
