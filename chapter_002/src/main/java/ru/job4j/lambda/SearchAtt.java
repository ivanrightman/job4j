package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
           if (predicate.equals(att)) {
               rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> forSize = new ArrayList<>();
        Attachment att101 = new Attachment("size101", 101);
        Attachment att100 = new Attachment("size100bug", 100);
        forSize.add(att101);
        forSize.add(att100);
        List<Attachment> fromFSize = filterSize(forSize);
        System.out.println(fromFSize);

        List<Attachment> fromFName = filterName(forSize);
        System.out.println(fromFName);
    }
}