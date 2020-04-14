package ru.job4j.stream;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = (left, right) -> {
            System.out.println("compare - " + left.getCity() + " : " + right.getCity());
            return left.getCity().compareTo(right.getCity());
        };

        List<Address> result = profiles.stream().map(Profile::getAddress).sorted(comparator).distinct().collect(Collectors.toList());
        return result;
    }
}
