package ru.job4j.lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonFuncTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResult() {
        List<Double> result = Function.diapason(4, 7, x -> 2 * Math.pow(x, 2) + 1 * x + 3);
        List<Double> expected = Arrays.asList(39D, 58D, 81D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPermanentFunctionThenFunctionResults() {
        List<Double> result = Function.diapason(2, 5, x -> 2 * x);
        List<Double> expected = Arrays.asList(4D, 6D, 8D);
        assertThat(result, is(expected));
    }
}
