package org.example.realss.Service;

import org.example.realss.Models.Person;

import java.util.List;

public interface PersonService {
    Person findByName(String userName);
    Person findPersonById(Long id);
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(Long id);
    List<Person> findAll();

}
