package io.github.joxebus.test

import spock.lang.Specification

class ExampleSpec extends Specification{

    def "When an element is added to a list the size must change"(){
        given: "a list of 4 numbers"
        List numbers = [2, 3, 5, 7]

        when:"add a new element"
        numbers.add(11)

        then:"the new size must be 5 and the old size should be 4"
        numbers.size() == 5
        old(numbers.size()) == 4

    }
}
