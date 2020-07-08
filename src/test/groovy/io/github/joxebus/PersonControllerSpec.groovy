package io.github.joxebus


import io.github.joxebus.controller.PersonController
import io.github.joxebus.entity.Person
import io.github.joxebus.service.PersonService
import spock.lang.Shared
import spock.lang.Specification

class PersonControllerSpec extends Specification {

    PersonController personController
    PersonService personService

    @Shared Person person

    def setup(){

    }

    def "Test PersonService create method is called"(){
        when:

        then:
        1 * personService.create(person)
    }

    def "Test PersonService list method is called"(){
        when:

        then:
        1 * personService.findAll()
    }

    def "Test PersonService find by id is called"(){
        when:


        then:
        1 * personService.findById(1)
        1 * personService.findById(2)
    }

    def "Test PersonService update method is called"(){
        given:

        when:

        then:
        1 * personService.update(person)
    }

    def "Test PersonService delete method is called"(){
        when:

        and:

        then:
        1 * personService.create(person)
        1 * personService.delete(person.id)
    }



}
