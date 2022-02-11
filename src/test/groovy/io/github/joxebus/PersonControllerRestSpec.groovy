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
        def entity = restTemplate.getForEntity("/people/", List<Person>)

        then: "status code OK and values are the expected"
        entity.statusCode    == HttpStatus.OK
        entity.body instanceof List
    }

    def "/people should save via post"(){
        given: "A new person is created"
        Person person = new Person()
        // TODO setup values to Person
        person.with {
            name = "Julio"
            lastName = "Chavez"
            age = 32
            phone = "153-897-2345"

        }

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        when: "The person is sent via POST"
        def response = restTemplate.postForEntity("/people/", data, Person)

        then: "status code CREATED and values are the expected"
        response.statusCode == HttpStatus.CREATED
        response.body.id > 0
    }


    def "/people delete and get list"(){
        when: "Get all the people from /people/ url"
        def response = restTemplate.getForEntity("/people/", List<Person>)

        and: "Last person is deleted"
        Person person = response.body.last()
        restTemplate.delete("/people/${person.id}")

        and: "Retrieve the list after delete the person"
        response = restTemplate.getForEntity("/people/", List<Person>)

        then: "status code OK and values are the expected"
        response.statusCode == HttpStatus.OK
        response.body instanceof List

    }

    def "/people update the first element"(){
        given: "Get the person with ID 1"
        def entity = restTemplate.getForEntity("/people/1", Person)

        when: "Change the data and send it to update"
        Person person  = entity.body
        person.with {
            name = "David"
            lastName = "Copperfield"
        }

        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(person, requestHeaders)

        restTemplate.put("/people/", data, Person)

        and:
        def response = restTemplate.getForEntity("/people/1", Person)

        then: "status code OK and values are the expected"
        response.statusCode == HttpStatus.OK
        response.body.with {
            name == "David"
            lastName == "Copperfield"
        }

    }

    def "/people save should throw 400"() {
        given: "A person is declared with invalid data"
        Person personNotValid = new Person()
        personNotValid.with {
            name = "John"
            lastName = "Doe"
            age = 50
            phone = "123-3453464"
        }

        when: "Try to save via POST the person"
        HttpHeaders requestHeaders = new HttpHeaders()
        requestHeaders.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<Person> data = new HttpEntity<>(personNotValid, requestHeaders)
        def response = restTemplate.postForEntity("/people/", data, Person)

        then: "status code BAD_REQUEST and values are the expected"

        response.statusCode == HttpStatus.BAD_REQUEST
        // where: ""
        // newName    |  newLastName   |   newAge  |   newPhone
    }
}
