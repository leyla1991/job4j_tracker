package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int j) {
        return j - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int a) {
        return divide(a) + multiply(a) + Calculator.sum(a) + Calculator.minus(a);

    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int min = Calculator.minus(5);
        System.out.println(min);
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(30));

    }
}


