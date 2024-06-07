package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.oop.tracker.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFindItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Find item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(item.toString());
        findByIdAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenNotFindItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        int id = 0;
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        findByIdAction.execute(input, memTracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: " + id + " не найдена." + ln
        );
    }
}
