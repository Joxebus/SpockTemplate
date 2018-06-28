package com.nearsoft.repository;

import com.nearsoft.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person save(Person newPerson) {
        if(newPerson.getId() == 0){
            entityManager.persist(newPerson);
        }
        return newPerson;
    }

    public List<Person> list() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        Person dbPerson = entityManager.find(Person.class, person.getId());
        if(dbPerson != null){
            dbPerson.setName(person.getName());
            dbPerson.setLastName(person.getLastName());
            dbPerson.setPhone(person.getPhone());
            dbPerson.setAge(person.getAge());
            entityManager.persist(dbPerson);
        }
        return dbPerson;
    }

    public void delete(Person person) {
        Person dbPerson = entityManager.find(Person.class, person.getId());
        if(dbPerson != null){
            entityManager.remove(dbPerson);
        }
    }
}
