package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    List<Integer> convert(Integer[][] matrix) {
        List<Integer> result = Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
        return result;
    }
}
