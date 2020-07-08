package io.github.joxebus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.joxebus.entity.Person;
import io.github.joxebus.repository.PersonRepository;
import io.github.joxebus.utils.PersonValidator;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person newPerson) {
        PersonValidator.validate(newPerson);
        Person person = personRepository.save(newPerson);
        logger.debug("Person created: {}", person);
        return person;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Person newPerson) {
        PersonValidator.validate(newPerson);
        if(newPerson.getId() < 1){
            throw new IllegalArgumentException("Can't update person with id ="+newPerson.getId());
        }
        Person person;
        person = personRepository.findById(newPerson.getId())
                .orElseThrow(() -> new IllegalArgumentException("The person can't be updated."));

        person.setName(newPerson.getName());
        person.setLastName(newPerson.getLastName());
        person.setAge(newPerson.getAge());
        person.setPhone(newPerson.getPhone());
        person = personRepository.save(person);
        logger.debug("Person updated: {}", person);
        return person;
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't delete person with id ="+id));
        logger.debug("Deleting person: {}", person);
        personRepository.delete(person);
    }

    public Person findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no person with id ="+id));
        logger.debug("Person found: {}", person);
        return person;
    }


}
