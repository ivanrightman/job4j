package ru.job4j.condition;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void distance() {
        int x1 = 2;
        int x2 = 3;
        int y1 = 4;
        int y2 = 5;
        double expected = 1.414;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
