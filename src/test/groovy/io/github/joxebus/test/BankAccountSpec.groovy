package io.github.joxebus.test

import io.github.joxebus.beans.BankAccount
import io.github.joxebus.services.BankAccountService
import spock.lang.Shared
import spock.lang.Specification

class BankAccountSpec extends Specification {

    @Shared
    BankAccountService bankAccountService

    def setupSpec() {
        bankAccountService = new BankAccountService()
        println "Executed once"
    }

    def "An account should increment money on deposit"(){
        given: "An account and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 0)

        when: "When the service deposit in the account 100"
        bankAccountService.deposit(bankAccount, 100.0)

        then: "The balance should be 100"
        bankAccountService.balance(bankAccount) == 100.0

    }

    def "An account should decrement money on withdraw"(){
        given: "An account with 100 and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 100.0)

        when: "When the service withdraw from the account 50"
        bankAccountService.withdraw(bankAccount, 50.0)

        then: "The balance should be 50"
        bankAccountService.balance(bankAccount) == 50.0

    }

}
