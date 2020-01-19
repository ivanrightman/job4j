package ru.job4j.array;

public class Min {
    public static int findMin(int[] array) {
        int min = array[0];
        for (int index = 0; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
            }
         /* enhanced for:
         for (int i : array) {
            if (i < min) {
                min = i;
            }
          */
        }
        return min;
    }
}
