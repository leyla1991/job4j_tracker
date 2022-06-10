package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int num = 1;
        BiConsumer<Integer, String> biCon = (i, s1) -> map.put(i, s1);
        for (String s1 : list) {
            biCon.accept(num++, s1);
        }

        BiPredicate<Integer, String> biPred = (i, s1) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            System.out.println("key: " + i + " value: " + biPred.test(i, map.get(i)));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = (s) -> System.out.println(s);
        for (String s : sup.get()) {
            con.accept(s);
        }

        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : sup.get()) {
            System.out.println(func.apply(s));
        }
    }
}
