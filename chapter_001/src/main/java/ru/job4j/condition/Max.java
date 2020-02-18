package ru.job4j.condition;


public class Max {
    public static int max(int left, int right) {
        /* boolean condition = left <= right;
        return condition ? right : left; */

        //более простой вариант:
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third) {
        int another = max(second, third);
        return max(first, another);
    }

    public static int max(int first, int second, int third, int fourth) {
        int another = max(second, third, fourth);
        return first > another ? first : another;
    }
}
