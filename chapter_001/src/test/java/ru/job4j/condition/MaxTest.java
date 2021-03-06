package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void maxIsRight() {
        int result = Max.max(123456789, 1234567890);
        assertThat(result, is(1234567890));
    }

    @Test
    public void leftEqualRight() {
        int result = Max.max(98765, 98765);
        assertThat(result, is(98765));
    }

    @Test
    public void firstBiggerThan2ndAnd3rd() {
        int result = Max.max(1234567890, 42, 23);
        assertThat(result, is(1234567890));
    }

    @Test
    public void fourthBiggerThan1stAnd2ndAnd3rd() {
        int result = Max.max(1234567, 123456, 12345678, 123456789);
        assertThat(result, is(123456789));
    }
}
