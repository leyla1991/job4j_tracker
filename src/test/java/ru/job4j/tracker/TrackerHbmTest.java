package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @AfterEach
    public void deleteItems() {
        try (var tracker = new HbmTracker()) {
                var items = tracker.findAll();
                for (Item item : items) {
                    tracker.delete(item.getId());
                }
        }
    }

    @Test
    public void addNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenEdit() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            Item replaceItem = new Item("test2");
            int id = item.getId();
            tracker.replace(id, replaceItem);
            Item result = tracker.findById(id);
            assertThat(result.getName()).isEqualTo(replaceItem.getName());
        }
    }

    @Test
    public void whenDelete() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1", 1);
            tracker.add(item);
            tracker.delete(1);
            assertThat(tracker.findByName(item.getName())).isEmpty();
        }
    }

    @Test
    public void whenFindByAll() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1", 1);
            Item item2 = new Item("test2", 2);
            Item item3 = new Item("test3", 3);
            tracker.add(item);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> result = Arrays.asList(item, item2, item3);
            List<Item> actual = tracker.findAll();
            assertThat(actual).usingRecursiveAssertion().isEqualTo(result);
        }
    }

    @Test
    public void whenFindById() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1", 1);
            tracker.add(item);
            assertThat(item.getName()).isEqualTo(tracker.findById(item.getId()).getName());
        }
    }

    @Test
    public void whenFindByName() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1", 1);
            Item item2 = new Item("test2", 2);
            Item item3 = new Item("test3", 3);
            tracker.add(item);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> result = tracker.findByName(item.getName());
            assertThat(result).hasSize(1).contains(item);
        }
    }
}
