package ru.job4j.condition;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(2, 4);
        Point b = new Point(3, 5);
        double expected = 1.414;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3d() {
        Point a = new Point(75, 67, 77);
        Point b = new Point(4, 7, 9);
        double expected = 92.956;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
