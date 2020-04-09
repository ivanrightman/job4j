package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void comparatorAscByName() {
        Comparator<Job> cmpAscName = new JobDescByName();
        int rsl = cmpAscName.compare(
                new Job("Impl task", 0),
                new Job("1 bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void comparatorAscByPriority() {
        Comparator<Job> cmpAscPrior = new JobDescByPriority();
        int rsl = cmpAscPrior.compare(
                new Job("Impl task", 0),
                new Job("0 bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void comparatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("1 bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void comparatorDescByPriority() {
        Comparator<Job> cmpDescPrior = new JobDescByPriority();
        int rsl = cmpDescPrior.compare(
                new Job("Impl task", 0),
                new Job("0 bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByNameAndThenByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriorityAndThenByName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndThenByPriority() {
        Comparator<Job> cmpAscNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpAscNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriorityAndThenByName() {
        Comparator<Job> cmpAscNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpAscNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}