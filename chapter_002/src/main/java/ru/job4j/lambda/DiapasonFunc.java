package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunc {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index < end; index++) {
            double x = func.apply((double) index);
            result.add(x);
        }
        return result;
    }
}
