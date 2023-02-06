package ru.job4j.oop.tracker;

public class SingleTracker {
    private static SingleTracker single = null;

    private Store tracker = new SqlTracker();

    private SingleTracker() {

    }

    public static SingleTracker getSingle() {
        if (single == null) {
            single = new SingleTracker();
        }
        return single;
    }

    public Item add(Item item) {
        return (Item) tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    public Item[] findAll() {
        return null;
    }

    public Item[] findByName(String key) {
        return null;
    }

    private int indexOf(int id) {
        return 0;
    }

    public boolean replace(int id, Item item) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
