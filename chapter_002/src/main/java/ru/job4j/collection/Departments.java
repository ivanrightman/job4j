package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (!start.equals("")) {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                } else {
                    tmp.add(el);
                    start = el;
                }

            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator depDesc = new DepDescComp();
        Collections.sort(orgs, depDesc);
    }
}