package io.github.joxebus.test

import io.github.joxebus.beans.Person
import io.github.joxebus.controller.PersonController
import io.github.joxebus.service.PersonService
import io.github.joxebus.service.PersonServiceImpl
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonComponentsSpec extends Specification {

    @Shared
    private PersonService personService
    @Shared
    private PersonController personController

    def "Stub objects provide a valid response"(){
        setup: "the person service stub and a controller with the service"
        personService = Stub()
        personController = new PersonController(
                personService: personService
        )

        and: "setup service response creating a new person"
        personService.create(name,_,age) >> new Person(name: name, age: age)

        when: "call the method create on controller with any parameter"
        Person person = personController.create("something","something", 0)

        then:"validate the response object is the same as the created in the stubbed interaction"

        person.with {
            it.name == name
            it.age == age
            !phone
        }

        where: "Information provided as data table with name and age"
        name    |   age
        "Sofia" |   28
        "Oscar" |   31
        "Omar"  |   30

    }

    def "Mock objects validate that certain methods are called"(){
        setup: "a personService Mock and a controller with that mock"
        personService = Mock()
        personController = new PersonController(
                personService: personService
        )

        when: "when the method create is called on the controller"
        personController.create("Omar", "423-132-2341", 32)

        then: "validate the interaction with the service and the parameters sent"

        1 * personService.create("Omar", "423-132-2341", 32)

    }

    @Unroll("Testing exception is thrown with phone #phone and #age")
    def "Test exception with different data"(){
        given: "personService with a real implementation and a controller with that service"
        personService = new PersonServiceImpl()
        personController = new PersonController(personService: personService)

        when: "controller recieves data to create a person with the wrong format phone"
        Person person = personController.create(name, phone, age)

        then: "the service throws a RuntimeException"
        thrown RuntimeException

        where: "Information provided as data pipes"
        name  << ["Sofia", "Oscar", "Omar"]
        phone << ["123-1234-12", "124-762341","987-234-124"]
        age   << [24, 29, 32]

    }
}
