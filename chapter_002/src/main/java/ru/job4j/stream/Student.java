package ru.job4j.stream;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Student() {

    }

    public Student(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }
}
