package ru.job4j.strategy;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(square),
                is(new StringJoiner(System.lineSeparator())
                        .add("++++")
                        .add("+     +")
                        .add("+     +")
                        .add("++++")
                        .toString()
                )
        );
    }

}
