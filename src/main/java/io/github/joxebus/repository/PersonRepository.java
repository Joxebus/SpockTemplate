package io.github.joxebus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.joxebus.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
