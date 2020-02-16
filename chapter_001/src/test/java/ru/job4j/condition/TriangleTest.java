package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point ap = new Point(5, 4);
        Point bp = new Point(4, 4);
        Point cp = new Point(4, 6);
        Triangle triangle = new Triangle(ap, bp, cp);
        double out = triangle.area();
        double expected = 1;
        assertThat(out, is(expected));
    }

    @Test
    public void whenNotExist() {
        Point ap = new Point(2, 5);
        Point bp = new Point(2, 6);
        Point cp = new Point(2, 7);
        Triangle triangle = new Triangle(ap, bp, cp);
        double out = triangle.area();
        double expected = -1;
        assertThat(out, is(expected));
    }
}
