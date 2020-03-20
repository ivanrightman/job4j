package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw(Shape shape) {
        StringBuilder pic = new StringBuilder(System.lineSeparator());
        pic.append("++++");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("++++");
        return pic.toString();
    }
}
