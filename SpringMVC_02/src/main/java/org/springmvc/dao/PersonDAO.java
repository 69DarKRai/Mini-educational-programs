package org.springmvc.dao;

import org.springframework.stereotype.Component;
import org.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static List<Person> people;
    private static int ID_COUNTER;

    {
        people = new ArrayList<>();

        people.add(new Person(++ID_COUNTER, "Amir"));
        people.add(new Person(++ID_COUNTER, "Nikita"));
        people.add(new Person(++ID_COUNTER, "Sergey"));
        people.add(new Person(++ID_COUNTER, "Oleg"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++ID_COUNTER);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}
