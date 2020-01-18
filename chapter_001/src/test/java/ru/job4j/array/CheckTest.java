package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CheckTest {

    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, true, true};
        boolean result = check.mono(data);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, false, true};
        boolean result = check.mono(data);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {false, false, false};
        boolean result = check.mono(data);
        assertThat(result,is(true));
    }

    @Test
    public void NotMonoBeginsWithTwoFalse() {
        Check check = new Check();
        boolean[] data = new boolean[] {false, false, true, true, true, true, true, true};
        boolean result = check.mono(data);
        assertThat(result, is(false));
    }

    @Test
    public void NotMonoBeginsWithTwoTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, true, false, false, false, false, false, false};
        boolean result = check.mono(data);
        assertThat(result, is(false));
    }
}
