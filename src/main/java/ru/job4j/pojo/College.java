package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("1");
        student.setDate("2 июля 2021");
        System.out.println(student.getFullName() + " учится в " +  student.getGroup()
        + " группе и поступил " + student.getDate());
    }
}
