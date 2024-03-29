package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.oop.tracker.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Exit menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Exit menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenValidInputNegative() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Exit menu");
        assertThat(selected, is(-2));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Edit Item");
        int selected2 = input.askInt("Show all Items");
        int selected3 = input.askInt("Exit menu");
        assertThat(selected, is(0));
        assertThat(selected2, is(1));
        assertThat(selected3, is(2));
    }
}
