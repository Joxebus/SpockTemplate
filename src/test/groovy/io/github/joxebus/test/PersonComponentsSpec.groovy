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

        when: "call the method create on controller with any parameter"

        then:"validate the response object is the same as the created in the stubbed interaction"


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

        then: "validate the interaction with the service and the parameters sent"


    }

    @Unroll("Testing exception is thrown with phone #phone and #age")
    def "Test exception with different data"(){
        given: "personService with a real implementation and a controller with that service"

        when: "controller receives data to create a person with the wrong format phone"

        then: "the service throws a RuntimeException"

        where: "Information provided as data pipes"
        name  << ["Sofia", "Oscar", "Omar"]
        phone << ["123-1234-12", "124-762341","987-234-124"]
        age   << [24, 29, 32]

    }
}
