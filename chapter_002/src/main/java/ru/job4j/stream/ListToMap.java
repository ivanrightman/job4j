package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    Map<String, Student> collect(List<Student> students) {
        Map<String, Student> result = students.stream().collect(
                Collectors.toMap(
                        student -> student.getName(),
                        student -> student,
                        (student1, student2) -> student1
                ));
        return result;
    }
}
