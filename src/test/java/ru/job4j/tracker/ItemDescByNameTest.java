package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenSortDescendingOrder() {
        List<Item> item = new ArrayList<>(List.of(
                new Item("Third", 3),
                new Item("Fourth", 4),
                new Item("First", 1),
                new Item("Second", 2)
        ));

        List<Item> expected = new ArrayList<>(List.of(
                new Item("Third", 3),
                new Item("Second", 2),
                new Item("Fourth", 4),
                new Item("First", 1)
        ));
        Collections.sort(item, new ItemDescByName());
        assertEquals(item, expected);
    }
}
