package ru.job4j.strategy;

import java.util.StringJoiner;

public class Triangle implements Shape {
    @Override
    public String draw(Shape shape) {
        StringBuilder  pic = new StringBuilder(System.lineSeparator());
        pic.append("   x ");
        pic.append("  xxx ");
        pic.append(" xxxxx ");
        return pic.toString();
    }
}
