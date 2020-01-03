package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SqMaxTest {
    @Test
    public void firstIsBigger() {
        int result = SqMax.max(999,2,3,4);
        assertThat(result, is(999));
    }

    @Test
    public void secondIsBigger() {
        int result = SqMax.max(1,999,3,4);
        assertThat(result, is(999));
    }

    @Test
    public void thirdIsBigger() {
        int result = SqMax.max(1,2,999,4);
        assertThat(result, is(999));
    }

    @Test
    public void fourthIsBigger() {
        int result = SqMax.max(1,2,3,999);
        assertThat(result, is(999));
    }

    @Test
    public void allIsEqual() {
        int result = SqMax.max(1,1,1,1);
        assertThat(result, is(1));
    }

    @Test
    public void twoIsEqual() {
        int result = SqMax.max(3,4,4,1);
        assertThat(result, is(4));
    }

    @Test
    public void firstTwoIsEqual() {
        int result = SqMax.max(4,4,2,1);
        assertThat(result, is(4));
    }

    @Test
    public void lastTwoIsEqual() {
        int result = SqMax.max(2,1,4,4);
        assertThat(result, is(4));
    }
}
