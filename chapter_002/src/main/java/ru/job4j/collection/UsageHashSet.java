package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UsageHashSet {
    public static void main(String[] args) {
        /*HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");*/
        HashSet<String> autos = new HashSet<>(
                Set.of("Lada", "BMW", "Volvo", "Toyota")
        );
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
