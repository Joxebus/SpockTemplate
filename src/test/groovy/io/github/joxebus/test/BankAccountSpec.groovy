package io.github.joxebus.test

import spock.lang.Specification

class BankAccountSpec extends Specification {

    def "An account should increment money on deposit"(){
        given: "An account and an accountService"

        when: "When the service deposit in the account 100"

        then: "The balance should be 100"

    }

    def "An account should decrement money on withdraw"(){
        given: "An account with 100 and an accountService"

        when: "When the service withdraw from the account 50"

        then: "The balance should be 50"

    }

}
