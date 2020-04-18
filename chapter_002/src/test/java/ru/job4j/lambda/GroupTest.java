package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupTest {

    @Test
    public void studentsSection() {
        List<Student> students = List.of(
                new Student("Student1", Set.of("section1", "section5")),
                new Student("Student2", Set.of("section1", "section2")),
                new Student("Student3", Set.of("section1", "section2", "section3")),
                new Student("Student4", Set.of("section1", "section2", "section3", "section4"))
        );
        Map<String, Set<String>> expected = Map.of(
                "section1", Set.of("Student1", "Student2", "Student3", "Student4"),
                "section2", Set.of("Student2", "Student3", "Student4"),
                "section3", Set.of("Student3", "Student4"),
                "section4", Set.of("Student4"),
                "section5", Set.of("Student1")

        );
        Map<String, Set<String>> result = Group.sections(students);
        assertThat(result, is(expected));
    }
}