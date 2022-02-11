package io.github.joxebus

import io.github.joxebus.controller.PersonController
import io.github.joxebus.entity.Person
import io.github.joxebus.service.PersonService
import spock.lang.Specification

/**
 * With this test you will be able to practice the
 * use of Mocks
 */

class PersonControllerSpec extends Specification {

    PersonController personController
    PersonService personService

    Person person

    def setup(){
        // first create a person object
        person = new Person()
        // then create a Mock of the service
        personService = Mock()
        // finally inject the service into the controller
        personController = new PersonController(personService)
    }

    def "Test PersonService create method is called"(){
        when: "Controller receives a person to create"
        personController.create(person)
        then: "Service method create is called 1 time"
        1 * personService.create(person)
    }

    def "Test PersonService list method is called"(){
        when: "Controller list method is called"
        personController.list()
        then: "Service method findAll is called 1 time"
        1 * personService.findAll()
    }

    def "Test PersonService find by id is called"(){
        when: "Controller is called 2 times"
        personController.getById(1)
        personController.getById(2)
        then: "Service method findById is called 2 times"
        1 * personService.findById(1)
        1 * personService.findById(2)
    }

    def "Test PersonService update method is called"(){
        when: "Controller receives a PUT operation for this person"
        personController.update(person)

        then: "Service method update is called with the person as parameter"
        1 * personService.update(person)
    }

    def "Test PersonService delete method is called"(){
        when: "Person is created via POST"
        personController.create(person)

        and: "The person returned is sent to the DELETE operation"
        personController.delete(person.id)

        then: "Service methods create and delete are called 1 time each"
        1 * personService.create(person)
        1 * personService.delete(person.id)
    }



}
