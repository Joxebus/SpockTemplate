package io.github.joxebus.test

import io.github.joxebus.beans.Person
import io.github.joxebus.controller.PersonController
import io.github.joxebus.service.PersonService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonComponentsSpec extends Specification {

    @Shared
    private PersonService personService
    @Shared
    private PersonController personController

    def "Stub objects provide a valid response"(){
        setup: "the person service stub"
        personService = Stub()
        personController = new PersonController(
                personService: personService
        )

        and: "setup the valid response"
        personService.create(_,_) >> new Person(name: name, age: age)

        when:"call the service"
        Person person = personController.create("something","something")

        then:"validate the interaction with the service"

        person.with {
            it.name == name
            it.age == age
            !phone
        }

        where: "Information provided as data table"
        name    |   age
        "Sofia" |   28
        "Oscar" |   31
        "Omar"  |   30

    }

    def "Mock objects validate that certain methods are called"(){
        setup:
        personService = Mock()
        personController = new PersonController(
                personService: personService
        )

        when:
        personController.create("Omar","423-132-2341")

        then: "validate the interaction with the service"

        1 * personService.create("Omar", "423-132-2341")

    }

    @Unroll("Testing exception is thrown with phone #phone")
    def "Test exception with different data"(){
        given:
        personService = new PersonService()
        personController = new PersonController(personService: personService)

        when:
        Person person = personController.create(name, phone)

        then:
        thrown RuntimeException

        where: "Information provided as data pipes"
        name  << ["Sofia", "Oscar", "Omar"]
        phone << ["123-1234-12", "124-762341","987-234-124"]

    }
}
