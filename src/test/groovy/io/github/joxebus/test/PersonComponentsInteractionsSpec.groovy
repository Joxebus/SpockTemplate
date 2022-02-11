package io.github.joxebus.test


import spock.lang.Specification

class PersonComponentsInteractionsSpec extends Specification {

    private PersonService personService
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


}
