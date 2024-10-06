package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new CreateAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new EditAction(out),
                        new ExitAppAction(out))
        );

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new DeleteAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit the App." + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new EditAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit Item." + ln
                        + "1. Exit the App." + ln
                        + "=== Edit item ===" + ln
                        + "The item has been changed." + ln
                        + "Menu." + ln
                        + "0. Edit Item." + ln
                        + "1. Exit the App." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new FindByIdAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find Item by Id." + ln
                        + "1. Exit the App." + ln
                        + "=== Look up by item's id ===" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find Item by Id." + ln
                        + "1. Exit the App." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new FindByNameAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find Item by Name." + ln
                        + "1. Exit the App." + ln
                        + "=== Look up by item's name ===" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find Item by Name." + ln
                        + "1. Exit the App." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item itemOne = tracker.add(new Item("itemOne"));
        Item itemTwo = tracker.add(new Item("itemTwo"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(
                List.of(new ShowAllAction(out),
                        new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all Items." + ln
                        + "1. Exit the App." + ln
                        + "=== Show all Items ===" + ln
                        + itemOne + ln
                        + itemTwo + ln
                        + "Menu." + ln
                        + "0. Show all Items." + ln
                        + "1. Exit the App." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(
                List.of(new ExitAppAction(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                                + "0. Exit the App." + ln
                                + "Wrong input, you can select: from 0 to 0." + ln
                                + "Menu." + ln
                                + "0. Exit the App." + ln
                                + "=== Exit Program ===" + ln
        );
    }
}