package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemAscByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 3),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameRise() {
        Comparator<Job> cmpNameRise = new JobRiseByName();
        int rsl = cmpNameRise.compare(
                new Job("Petr", 3),
                new Job("Ivan", 4)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> cmpNameDesc = new JobDescByName();
        int rsl = cmpNameDesc.compare(
                new Job("Ivan", 5),
                new Job("Anna", 4)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityRiseAndNameRise() {
        Comparator<Job> cmpNamePriority = new JobRiseByName().thenComparing(new JobRiseByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 3),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityRise() {
        List<Job> jobs =  new ArrayList<>();
        jobs.add(new Job("Liza", 3));
        jobs.add(new Job("Petr", 4));
        jobs.add(new Job("Ivan", 2));
        Collections.sort(jobs, new JobRiseByPriority());
        List<Job> expected =  new ArrayList<>();
        expected.add(new Job("Ivan", 2));
        expected.add(new Job("Liza", 3));
        expected.add(new Job("Petr", 4));
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int rsl = cmpDescByPriority.compare(
                new Job("Ivan", 2),
                new Job("Petr", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}