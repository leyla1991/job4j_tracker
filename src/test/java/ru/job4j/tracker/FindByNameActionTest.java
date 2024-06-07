package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.oop.tracker.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFindItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item =  memTracker.add(new Item("Find item"));

        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByNameAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenNotFindItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        findByNameAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + input.askStr("") + " не найдены." + ln
        );
    }
}
