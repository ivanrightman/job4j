package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };

        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return left.getSize() - right.getSize();
        };

        Comparator<Attachment> cmpText = (left, right) -> {
            System.out.println("compare cmpText - " + left.getName() + " : " + right.getName());
            return left.getName().compareTo(right.getName());
        };

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare DescSize - " + right.getSize() + " : " + left.getSize());
            return right.getSize() - left.getSize();
        };

        System.out.println("sorting on size asc:");
        sort(atts, comparator);
        System.out.println(Arrays.toString(atts));
        System.out.println("sorting on size desc:");
        sort(atts, cmpDescSize);
        System.out.println(Arrays.toString(atts));
        System.out.println("sorting on name natural:");
        sort(atts, cmpText);
        System.out.println(Arrays.toString(atts));
    }
}