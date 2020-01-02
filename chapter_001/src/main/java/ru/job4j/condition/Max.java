package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        /* boolean condition = left <= right;
        return condition ? right : left; */

        //более простой вариант:
        return left > right ? left : right;
    }
}
