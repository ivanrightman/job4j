package ru.job4j.sort;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] result = machine.change(100, 100);
        assertThat(result, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] result = machine.change(50, 35);
        assertThat(result, is(expected));
    }

    @Test
    public void when50by32() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 1};
        int[] result = machine.change(50, 32);
        assertThat(result, is(expected));
    }

    @Test
    public void when100by32() {
        Machine machine = new Machine();
        int[] expected = {10, 10, 10, 10, 10, 10, 5, 2, 1};
        int[] result = machine.change(100, 32);
        assertThat(result, is(expected));
    }

}
