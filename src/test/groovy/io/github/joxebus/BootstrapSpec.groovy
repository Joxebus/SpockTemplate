package io.github.joxebus

import io.github.joxebus.service.PersonService
import io.github.joxebus.config.Bootstrap
import spock.lang.Specification

class BootstrapSpec extends Specification {

    PersonService personService
    Bootstrap bootstrap

    def setup(){
        // TODO Mock personService and setup into Bootstrap
        personService = Mock()
        bootstrap = new Bootstrap(personService)
    }

    def "Test interactions between Bootstrap and PersonService"(){
        when: "init() method is called"
        bootstrap.init()

        then: "the method find all should be call 1 time"
        1 * personService.findAll()

        and: "the create method should be called 5 times"
        5 * personService.create(_)
    }

}
