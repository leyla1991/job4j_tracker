package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFindName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Anton");
        assertTrue(persons.isEmpty());
    }
}
