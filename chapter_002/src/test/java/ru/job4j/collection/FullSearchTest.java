package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = List.of(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Set.of("1", "2"));
        assertThat(FullSearch.extractNumber(list), is(expected));

    }
}
