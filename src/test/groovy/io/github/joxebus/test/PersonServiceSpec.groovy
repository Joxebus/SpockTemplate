package io.github.joxebus.test


import spock.lang.Shared
import spock.lang.Specification

class PersonServiceSpec extends Specification {

    @Shared
    PersonService personService

    def setupSpec() {
        personService = new PersonServiceImpl()
    }


    def "Test the create method of the PersonService" () {
        given: "PersonService and a call and person object"
        String name = "Omar"
        String phone = "123-756-8753"
        int age = 34

        when: "Person is sent to method create"
        Person person = personService.create(name, phone, age)

        then: "Validate all the data returned is the same"
        person.with {
            it.name == name
            it.phone == phone
            it.age == age
        }

    }

    def "Testing exception is thrown with invalid phone format"(){
        when: "receives data to create a person with the wrong format phone"
        personService.create(name, phone, age)

        then: "the service throws a RuntimeException"
        thrown RuntimeException

        where: "Information provided as data table"
        name    |   phone       |   age
        "Sofia" | "123-1234-12" |   24
        "Oscar" | "124-762341"  |   29
        "Omar"  | "987-234-124" |   32

    }
}
