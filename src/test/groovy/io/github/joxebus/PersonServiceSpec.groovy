package io.github.joxebus

import io.github.joxebus.entity.Person
import io.github.joxebus.service.PersonService
import io.github.joxebus.repository.PersonRepository
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * With this test you will be able to practice the
 * use of Mocks
 */
class PersonServiceSpec extends Specification {

    PersonService personService
    PersonRepository personRepository

    @Shared
    Person person

    def setup(){
        // TODO Mock repository and setup to service
        personRepository = Mock()
        personService = new PersonService(personRepository)
        // TODO Create a new person with some test values
        person = new Person()
        person.with {
            name = "Omar"
            lastName = "Bautista"
            age = 32
            phone = "653-352-9084"
        }

    }

    def "Person Service call repository save when entity has valid values"(){
        when: "service create person is called"
        personService.create(person)

        then: "repository save method should be called once"
        1 * personRepository.save(person)
    }

    @Unroll("Testing invalid values name=#name, lastName=#lastName, age=#age, phone=#phone")
    def "Person with invalid phone throw IllegalArgumentException"(){
        given: "a person with some values"
        Person anotherPerson = new Person()
        anotherPerson.with {
            it.name = name
            it.lastName = lastName
            it.age = age
            it.phone = phone
        }

        when: "service send the person to be created"
        personService.create(anotherPerson)


        then: "an IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)

        where: "defined values to test"
        name        |   lastName    |   age  |   phone
        "Omar"      |   "Bautista"  |   32   |   "234765-2345"
        "Diana"     |   "Ramirez"   |   31   |   "432-8716-345"
        "Alberto"   |   "Rubalcaba" |   28   |   "763-7654523"
        "Daniela"   |   "Perez"     |   26   |   "7643451834"

    }

    def "Find a person by id"(){
        given: "a stubed respository and a service instance"
        personRepository = Stub()
        personService = new PersonService(personRepository)

        and: "setup the return when call the findById method with id 1"
        personRepository.findById(1) >> Optional.of(new Person([
                id:1,
                name:"Omar",
                lastName:"Bautista",
                age:32,
                phone:"653-352=9084"
        ]))

        when: "should return a predefined Person"
        Person person = personService.findById(1)

        then: "the person should contain the expected values"
        person.with {
            id       == 1
            name     == "Omar"
            lastName == "Bautista"
            age      == 32
            phone    == "653-352=9084"
        }

    }

    def "Delete person throw exception"(){
        when: "when delete a unexisting person"
        personService.delete(100)

        then: "a RuntimeException is thrown"
        thrown(RuntimeException)

    }

}
