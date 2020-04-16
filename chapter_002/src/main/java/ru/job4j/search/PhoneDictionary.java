package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> nameContainsKey = person -> person.getName().contains(key);
        Predicate<Person> surnameContainsKey = person -> person.getSurname().contains(key);
        Predicate<Person> phoneContainsKey = person -> person.getPhone().contains(key);
        Predicate<Person> addressContainsKey = person -> person.getAddress().contains(key);
        boolean outcome = nameContainsKey.or(surnameContainsKey.or(phoneContainsKey.or(addressContainsKey))).test(persons.get(0));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (outcome) {
                result.add(person);
            }
        }
        return result;
    }
}
