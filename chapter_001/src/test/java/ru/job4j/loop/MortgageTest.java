package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MortgageTest {

    @Test
    public void when1Year() {
        Mortgage check = new Mortgage();
        int result = check.year(1000, 1200, 0.10);
        assertThat(result, is(1));
    }

    @Test
    public void when2Year() {
        Mortgage check = new Mortgage();
        int result = check.year(100, 120, 0.50);
        assertThat(result, is(2));
    }
}
