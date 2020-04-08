package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {5, 10, 3};
        int el = 5;
        int result = find.indexOf(data, el);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void noElementInArray() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {20, 33, 44};
        int el = 15;
        int result = find.indexOf(data, el);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {5, 2, 10, 2, 4};
        int el = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(data, el, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindNothing() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {321, 123, 125, 1, 10};
        int el = 4;
        int start = 0;
        int finish = 4;
        int result = find.indexOf(data, el, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

}
