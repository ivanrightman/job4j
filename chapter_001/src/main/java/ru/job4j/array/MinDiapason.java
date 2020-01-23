package ru.job4j.array;

public class MinDiapason {
    public static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (int i = start; i < finish; i++) { //исправил, т.к. не проходил SortSelectedTest. Но при i < finish перестал проходить whenLastMin() в MinDiapasonTest, т.к. единица находится в 3 элементе, а при i < finish крайний элемент 2
            if (array[i] <= min) {
                min = array[i];
            }
        }
        return min;
    }
}
