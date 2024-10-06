package ru.job4j.tracker;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущая дата: " + currentDate);
        System.out.println("Текущее время: " + currentTime);
        System.out.println("Текущие дата и время: " + currentDateTime);
        System.out.println("Текущие дата и время отформатированные: " + currentDateTimeFormat);
    }
}
