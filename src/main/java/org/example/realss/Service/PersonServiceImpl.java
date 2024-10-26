package org.example.realss.Service;

import org.example.realss.Models.Person;
import org.example.realss.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person findByName(String userName) {
        Optional<Person> person = personRepository.findByUsername(userName);
        return person.orElse(new Person());
    }

    @Override
    public Person findPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(new Person());
    }

    @Transactional
    @Override
    public void savePerson(Person person) {
        person.setEncodedPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }

    //Переделать!
    @Transactional
    @Override
    public void updatePerson(Person person) {
    personRepository.save(person);

    }

    @Override
    public void deletePersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person deletePerson = person.get();
            personRepository.deleteById(id);
        }
    }

    //ПОМЕНЯТЬ НА ДТО
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
