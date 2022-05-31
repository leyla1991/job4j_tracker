package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public List<Item> add(Item item) {
        item.setId(ids++);
        items.add(item);
        return items;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public List<Item> findById(int id) {
        List<Item> find = new ArrayList<>();
        int index = indexOf(id);
        if (index != -1) {
            find.add(items.get(index));
        }
       return find;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return  rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index > -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}

