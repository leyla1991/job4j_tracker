package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book tale = new Book("Колобок", 30);
        Book novel = new Book("Унесенные ветром", 300);
        Book science = new Book("Clean code", 320);
        Book dictionary = new Book("Толковый словарь", 500);
        Book[] books = new Book[4];
        books[0] = tale;
        books[1] = novel;
        books[2] = science;
        books[3] = dictionary;
        for (int index = 0; index < books.length; index++) {
            Book bks = books[index];
            System.out.println(bks.getName() + " - " + bks.getCount() + " страниц.");
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int index = 0; index < books.length; index++) {
            Book bks = books[index];
            System.out.println(bks.getName() + " - " + bks.getCount() + " страниц.");
        }
        for (int i = 0; i < books.length; i++) {
            Book bks = books[i];
            if ("Clean code".equals(bks.getName())) {
                System.out.println(bks.getName() + " - " + bks.getCount() + " страниц.");
            }
        }
    }
}
