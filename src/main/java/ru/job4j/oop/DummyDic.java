package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic language = new DummyDic();
        String say = language.engToRus("Unknown");
        System.out.println(say);
    }
}
