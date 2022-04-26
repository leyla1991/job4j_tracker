package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Информация об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error12 = new Error(true, 12, "изменить строку");
        Error error3 = new Error(true, 3, "Нет пробела");
        Error error0 = new Error(false, 0, "Ошибок нет");
        error12.printInfo();
        error3.printInfo();
        error0.printInfo();
    }
}
