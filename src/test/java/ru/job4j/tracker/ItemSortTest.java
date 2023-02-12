package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.oop.tracker.Item;
import ru.job4j.oop.tracker.ItemAscByName;

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
}
