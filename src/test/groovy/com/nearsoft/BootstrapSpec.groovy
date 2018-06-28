package com.nearsoft

import com.nearsoft.config.Bootstrap
import com.nearsoft.service.PersonService
import spock.lang.Specification

class BootstrapSpec extends Specification {

    PersonService personService
    Bootstrap bootstrap

    def setup(){
        // TODO Mock personService and setup into Bootstrap
    }

    def "Test init method"(){
        when: "init() method is called"

        then: "the method find all should be call 1 time"

        and: "the create method should be called 5 times"
    }

}
