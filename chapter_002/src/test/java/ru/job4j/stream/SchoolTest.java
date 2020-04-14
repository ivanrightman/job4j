package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void whenAClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student student69 = new Student(69);
        Student student70 = new Student(70);
        Student student71 = new Student(71);
        Student student80 = new Student(80);
        Student student99 = new Student(99);
        Student student100 = new Student(100);
        students.add(student69);
        students.add(student70);
        students.add(student71);
        students.add(student80);
        students.add(student99);
        students.add(student100);
        List<Student> expected = Arrays.asList(student70, student71,
                student80, student99, student100);
        List<Student> result = school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student student49 = new Student(49);
        Student student50 = new Student(50);
        Student student60 = new Student(60);
        Student student69 = new Student(69);
        Student student70 = new Student(70);
        students.add(student49);
        students.add(student50);
        students.add(student60);
        students.add(student69);
        students.add(student70);
        List<Student> expected = Arrays.asList(student50, student60,
                student69);
        List<Student> result = school.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCClass() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Student studentMinusOne = new Student(-1);
        Student student0 = new Student(0);
        Student student1 = new Student(1);
        Student student22 = new Student(22);
        Student student49 = new Student(49);
        Student student50 = new Student(50);
        students.add(studentMinusOne);
        students.add(student0);
        students.add(student1);
        students.add(student22);
        students.add(student49);
        students.add(student50);
        List<Student> expected = Arrays.asList(student0, student1,
                student22, student49);
        List<Student> result = school.collect(students, student -> student.getScore() >= 0 && student.getScore() < 50);
        assertThat(result, is(expected));
    }
}
