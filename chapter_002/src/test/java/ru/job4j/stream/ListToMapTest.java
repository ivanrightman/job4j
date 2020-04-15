package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ListToMapTest {
    @Test
    public void surnameIsKeyStudentIsValue() {
        ListToMap listToMap = new ListToMap();
        Student student = new Student(100, "Ivanov");
        Student student2 = new Student(100, "Petrov");
        List<Student> input = List.of(student, student2);
        Map<String, Student> result = listToMap.collect(input);
        assertThat(result.get("Ivanov"), is(student));
    }

    @Test
    public void surnameIsKeyStudentIsValueWhenDuplicateKey() {
        ListToMap listToMap = new ListToMap();
        Student student = new Student(100, "Ivanov");
        Student student2 = new Student(100, "Ivanov");
        List<Student> input = List.of(student, student2);
        Map<String, Student> result = listToMap.collect(input);
        assertThat(result.get("Ivanov"), is(student));
    }
}
