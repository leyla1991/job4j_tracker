package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> pName = s -> s.getName().contains(key);
        Predicate<Person> pAddress = s -> s.getAddress().contains(key);
        Predicate<Person> pSurname = s -> s.getSurname().contains(key);
        Predicate<Person> pPhone = s -> s.getPhone().contains(key);
        Predicate<Person> combine = pPhone.or(pAddress).or(pName).or(pSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
