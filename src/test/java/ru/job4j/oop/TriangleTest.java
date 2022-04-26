package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when40and62and64Then2() {
        Point a = new Point(4, 0);
        Point b = new Point(6, 2);
        Point c = new Point(6, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(2, 0.001));
    }

    @Test
    public void when50and22and63Then2() {
        Point a = new Point(5, 0);
        Point b = new Point(2, 2);
        Point c = new Point(6, 3);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(5.5, 0.001));
    }

    @Test
    public void when10and12and24NotBe() {
        Point a = new Point(1, 0);
        Point b = new Point(1, 2);
        Point c = new Point(1, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }
}
