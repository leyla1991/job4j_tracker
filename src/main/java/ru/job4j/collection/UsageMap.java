package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("atagleyla@mail.ru", "Leyla Ivannykova");
        for (String mail : map.keySet()) {
            String value = map.get(mail);
            System.out.println(mail + " = " + value);
        }
    }
}
