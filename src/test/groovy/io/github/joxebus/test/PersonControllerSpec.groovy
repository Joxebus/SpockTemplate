package io.github.joxebus.test

import spock.lang.Specification

class PersonControllerSpec extends Specification {

    def "Person controller action create"(){
        given: "PersonController object"
        PersonController personController = new PersonController()

        and: "values name phone and age"
        String name = "Omar"
        String phone = "123-756-8753"
        int age = 34

        when: "the method create with some values"
        Person person = personController.create(name, phone, age)

        then: "the result is an object with that values"
        person.with {
            it.name == name
            it.phone == phone
            it.age == age
        }
    }
}
