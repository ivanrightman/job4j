package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class MatrixToListTest {
    @Test
    public void matrixToList() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] input = new Integer[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = matrixToList.convert(input);
        assertThat(result, is(expected));
    }
}
