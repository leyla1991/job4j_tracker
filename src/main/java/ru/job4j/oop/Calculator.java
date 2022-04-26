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

    public int sumAllOperation() {
         int all = this.divide(25) + this.multiply(3) + Calculator.sum(2) + Calculator.minus(13);
         return all;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int min = Calculator.minus(5);
        System.out.println(min);
        Calculator div = new Calculator();
        System.out.println(div.divide(10));
        Calculator sumAll = new Calculator();
        System.out.println(sumAll.sumAllOperation());

    }
}
