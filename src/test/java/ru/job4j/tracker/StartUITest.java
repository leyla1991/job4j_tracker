package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditAction() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Edit name"));
        String editName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.get(0).getId()), editName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(0).get(0).getName(), is(editName));
    }

    @Test
    public void whenDeleteAction() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.get(0).getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertTrue(tracker.findById(0).isEmpty());
    }

    @Test
    public void whenExitAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu:" + System.lineSeparator()
    + "0. Exit" + System.lineSeparator() + "=== Exit Program ===" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.get(0).getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.get(0).getId()), "1"}
        );
        UserAction[] actions = new UserAction[] {
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

   @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> one = tracker.add(new Item("test1"));
        Input in = new StubInput(
               new String[] {"0", String.valueOf(one.get(0).getName()), "1"}
        );
        UserAction[] actions = new UserAction[] {
               new FindByNameAction(output),
                new ExitAction(output)
        };
       new StartUI(output).init(in, tracker, actions);
       String ln = System.lineSeparator();
       assertThat(output.toString(), is(
               "Menu:" + ln
                        + "0. Find items by name" + ln
                       + "1. Exit" + ln
                       + "=== Find items by name ===" + ln
                      + one.get(0) + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> one = tracker.add(new Item("test1"));
        List<Item> two = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[] {
                new ShowAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + one.get(0) + ln
                        + two.get(1) + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }
}

