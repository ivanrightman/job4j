package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] array = new int[] {4, 1, 6, 2};
        int[] result = turner.back(array);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 6};
        int[] result = turner.back(array);
        int[] expect = new int[] {6, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
