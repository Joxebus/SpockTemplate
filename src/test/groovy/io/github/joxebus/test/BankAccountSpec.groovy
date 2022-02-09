package io.github.joxebus.test

import io.github.joxebus.beans.BankAccount
import io.github.joxebus.exceptions.BankAccountException
import io.github.joxebus.services.BankAccountService
import spock.lang.Shared
import spock.lang.Specification

class BankAccountSpec extends Specification {

    @Shared
    BankAccountService service

    def setupSpec() {
        service = new BankAccountService()
    }

    def "An account should increment money on deposit"(){
        given: "An account and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 0)

        when: "When the service receive the account and 100"
        service.deposit(bankAccount, 100.0)

        then: "The balance should be 100"
        service.balance(bankAccount) == 100.0

    }

    def "An account should decrement money on withdraw"(){
        given: "An account with 100 and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 100.0)

        when: "When the service withdraw from the account 50"
        service.withdraw(bankAccount, 50.0)

        then: "The balance should be 50"
        service.balance(bankAccount) == 50.0
    }

    def "AccountService cannot withdraw a quantity higher than the money in the account"(){
        given: "An account with 50 and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 50.0)

        when: "When the service withdraw from the account 100"
        service.withdraw(bankAccount, 100.0)

        then: "The service should throw a BankAccountException"
        thrown BankAccountException

    }

    def "AccountService can withdraw a quantity lower than the money in the account"(){
        given: "An account with 200 and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 200.0)

        when: "When the service withdraw from the account 100"
        service.withdraw(bankAccount, 100.0)

        then: "The service should not throw a BankAccountException"
        notThrown BankAccountException

    }

    def "AccountService should call method getAmount on an account Mock"(){
        given: "An account mock"
        BankAccount bankAccount = Mock()

        when: "When the service call balance on account"
        service.balance(bankAccount)

        then: "The service should call getAmount on account 1 time"
        1 * bankAccount.getAmount()

    }

    def "AccountService should return an amount on an account Stub"(){
        given: "An account Stub"
        BankAccount bankAccount = Stub()
        bankAccount.getAmount() >> 100.0

        when: "When the service call balance on account"
        BigDecimal amount = service.balance(bankAccount)

        then: "The service should call getAmount on account 1 time"
        amount == 100.0

    }

}
