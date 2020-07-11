package io.github.joxebus

import io.github.joxebus.entity.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerRestSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    def "/people/{id} should return an element"(){
        when: "Get person"
        def entity = restTemplate.getForEntity("/people/1", Person)

        then: "Verify the response is 200 and data equals as the first element"
        entity.statusCode    == HttpStatus.OK
        entity.body.id       == 1
        entity.body.name     == "Jorge"
        entity.body.lastName == "Valenzuela"
        entity.body.age      == 24
        entity.body.phone    == '662-862-1248'
    }

    def "/people should return a list"(){
        when: "Get list"

        then: "status code OK and values are the expected"

    }

    def "/people should save via post"(){
        given: "A new person is created"
        Person person = new Person()
        // TODO setup values to Person

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        when: "The person is sent via POST"

        then: "status code CREATED and values are the expected"

    }


    def "/people delete and get list"(){
        when: "Person is deleted"

        and: "Retrieve the list after delete the person"

        then: "status code OK and values are the expected"

    }

    def "/people update the first element"(){
        given: "Get the person with ID 1"

        when: "Change the data and send it to update"

        then: "status code OK and values are the expected"

    }

    def "/people save should throw 400"() {
        given: "A person is declared with invalid data"

        when: "Try to save via POST the person"

        then: "status code BAD_REQUEST and values are the expected"

        // where: ""
        // newName    |  newLastName   |   newAge  |   newPhone
    }
}
