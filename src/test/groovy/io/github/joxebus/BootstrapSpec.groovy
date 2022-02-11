package io.github.joxebus


import io.github.joxebus.service.PersonService
import io.github.joxebus.config.Bootstrap
import spock.lang.Specification

class BootstrapSpec extends Specification {

    PersonService personService
    Bootstrap bootstrap

    def setup(){
        // TODO Mock personService and setup into Bootstrap
    }

    def "Test interactions between Bootstrap and PersonService"(){
        when: "init() method is called"

        then: "the method find all should be call 1 time"

        and: "the create method should be called 5 times"
    }

}
