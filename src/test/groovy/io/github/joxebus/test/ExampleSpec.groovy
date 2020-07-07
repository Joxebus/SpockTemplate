package io.github.joxebus.test

import spock.lang.Specification

class ExampleSpec extends Specification{

    def "Sum 2 numbers"(){
        given: "Two numbers 4 and 7"
        int a = 4
        int b = 7

        when:"Plus operation"

        int c = a+b

        then:"The result must be 11"

        c == 11
    }
}
