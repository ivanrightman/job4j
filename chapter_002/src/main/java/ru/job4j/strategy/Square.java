package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw(Shape shape) {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("++++");
        pic.add("+     +");
        pic.add("+     +");
        pic.add("++++");
        //pic.add(System.lineSeparator());
        return pic.toString();
    }
}
