package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void whenItemSortRise() {
        List<Item> items =  new ArrayList<>();
        items.add(new Item("Liza"));
        items.add(new Item("Petr"));
        items.add(new Item("Ivan"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected =  new ArrayList<>();
        expected.add(new Item("Ivan"));
        expected.add(new Item("Liza"));
        expected.add(new Item("Petr"));
        assertThat(expected, is(items));
    }

    @Test
    public void whenItemSortDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Liza", 3));
        items.add(new Item("Petr", 2));
        items.add(new Item("Ivan", 4));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Petr", 2));
        expected.add(new Item("Liza", 3));
        expected.add(new Item("Ivan", 4));
        assertThat(expected, is(items));
    }
}
