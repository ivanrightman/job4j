package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = /*Arrays.asList*/ List.of(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        //jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        jobs.stream().sorted(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);


        //Collections.sort(jobs, new JobAscByName().thenComparing(new JobAscByPriority()));
        jobs.stream().sorted(new JobAscByName().thenComparing(new JobAscByPriority()));
        System.out.println(jobs);

        //Collections.sort(jobs, new JobAscByName());
        jobs.stream().sorted(new JobAscByName());
        System.out.println("JobAscByName: " + jobs);

        //Collections.sort(jobs, new JobAscByPriority());
        jobs.stream().sorted(new JobAscByPriority());
        System.out.println("JobAscByPriority: " + jobs);
    }
}
