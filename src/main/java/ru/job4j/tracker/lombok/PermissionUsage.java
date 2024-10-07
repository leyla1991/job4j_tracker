package ru.job4j.tracker.lombok;

public class PermissionUsage {

    public static void main(String[] args) {
        Permission permission = Permission.of()
                .id(1)
                .name("Sugar")
                .accessBy("List")
                .accessBy("Save")
                .accessBy("Smith")
                .build();
        System.out.println(permission);
    }
}
