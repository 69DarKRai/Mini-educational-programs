package org.springmvc.dao;

import org.springframework.stereotype.Component;
import org.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "Amir"));
        people.add(new Person(2, "Nikita"));
        people.add(new Person(3, "Sergey"));
        people.add(new Person(4, "Oleg"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
