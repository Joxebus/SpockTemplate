package io.github.joxebus

import io.github.joxebus.entity.Person
import io.github.joxebus.repository.PersonRepository
import io.github.joxebus.service.PersonService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * With this test you will be able to practice the
 * use of Mocks
 */
class PersonServiceSpec extends Specification {

    PersonService personService
    PersonRepository personRepository

    Person person

    def setup(){
        // TODO Mock repository and setup to service

        // TODO Create a new person with some test values
    }

    def "Person Service call repository save when entity has valid values"(){
        when: "service create person is called"

        then: "repository save method should be called once"
    }

    def "Person with invalid phone throw IllegalArgumentException"(){
        given: "a person with some values"

        when: "service send the person to be created"

        then: "an IllegalArgumentException is thrown"

        where: "defined values to test"
        name        |   lastName    |   age  |   phone
        "Omar"      |   "Bautista"  |   32   |   "234765-2345"
        "Diana"     |   "Ramirez"   |   31   |   "432-8716-345"
        "Alberto"   |   "Rubalcaba" |   28   |   "763-7654523"
        "Daniela"   |   "Perez"     |   26   |   "7643451834"

    }

    def "Find a person by id"(){
        given: "a stubbed repository and a service instance"

        and: "setup the return when call the findById method with id 1"

        when: "should return a predefined Person"

        then: "the person should contain the expected values"

    }

    def "Delete person throw exception"(){
        when: "when delete a non-existing person"

        then: "a RuntimeException is thrown"

    }

}
