package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroToRuble() {
        int inEuro = 33;
        int inCourse = 70;
        int expected = 2310;
        int out = Converter.euroToRuble(inEuro, inCourse);
        Assert.assertEquals(expected, out);
    }

    @Test
    public  void dollarToRubble() {
        int inDollar = 27;
        int inCourse = 60;
        int expected = 1620;
        int out = Converter.dollarToRuble(inDollar, inCourse);
        Assert.assertEquals(expected, out);
    }
}


