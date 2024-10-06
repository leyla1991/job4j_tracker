package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrackerWithMockTest {

    Output output = new StubOutput();
    MemTracker tracker = new MemTracker();

    @Test
    void whenItemWasReplacedSuccessfully() {

        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "The item has been changed." + ln
        );
    }

    @Test
    void whenFailedToReplaceAnItem() {

        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(4);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Error when changing the item." + ln
        );
    }

    @Test
    void whenDeleteItemIsSuccessful() {

        tracker.add(new Item("test"));
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "The item has been deleted." + ln
        );
    }

    @Test
    void whenFailedToDeleteAnItem() {

        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Error when deleting the item." + ln
        );
    }

    @Test
    void whenCreateItemIsSuccessful() {

        String itemName = "testItem";
        CreateAction createAction = new CreateAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(0);
        when(input.askStr(any(String.class))).thenReturn(itemName);

        createAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).contains(
                "=== Create a new Item. ===" + ln
                        + "Added item: Item{id=1, name='testItem', created="
        );
    }

    @Test
    void whenFindByIdIsSuccessful() {

        Item item = new Item("name");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(output.toString()).isEqualTo(
                "=== Look up by item's id ===" + ln
                        + item + ln
        );
    }

    @Test
    void whenFailedToFindById() {

        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(output.toString()).isEqualTo(
                "=== Look up by item's id ===" + ln
                        + "Item" + " with id " + 1 + " is not found." + ln
        );
    }

    @Test
    void whenFindByNameIsSuccessful() {

        Item item = new Item("name");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("name");

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(output.toString()).isEqualTo(
                "=== Look up by item's name ===" + ln
                        + item + ln
        );
    }

    @Test
    void whenFailedToFindByName() {

        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("test");

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(output.toString()).isEqualTo(
                "=== Look up by item's name ===" + ln
                        + "Items" + " with name test are not found." + ln
        );
    }
}
