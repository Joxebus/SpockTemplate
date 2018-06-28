package com.nearsfot.test

import com.nearsoft.beans.BankAccount
import com.nearsoft.exceptions.BankAccountException
import com.nearsoft.services.BankAccountService
import spock.lang.Specification

class BankAccountSpec extends Specification {

    def "An account should increment money on deposit"(){
        given: "An account and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 0)
        BankAccountService service = new BankAccountService()

        when: "When the service receive the account and 100"
        service.deposit(bankAccount, 100)

        then: "The balance should be 100"
        service.balance(bankAccount) == 100

    }

    def "An account should decrement money on withdraw"(){
        given: "An account with 100 and an accountService"
        BankAccount bankAccount = new BankAccount(amount: 100)
        BankAccountService service = new BankAccountService()

        when: "When the service withdraw from the account 50"
        service.withdraw(bankAccount, 50)

        then: "The balance should be 50"
        service.balance(bankAccount) == 50
    }

    def "AccountService cannot withdraw a quantity higher than the money in the account"(){
        given: "An account with 50 and an accountService"

        when: "When the service withdraw from the account 100"

        then: "The service should throw a BankAccountException"

    }

    def "AccountService should call method getAmount"(){
        given: "An account and an accountService"

        when: "When the service receive the account and 100"

        then: "The service should call getAmount on account"

    }

}
