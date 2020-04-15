package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        List<Student> result = students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
        return result;
    }
}
