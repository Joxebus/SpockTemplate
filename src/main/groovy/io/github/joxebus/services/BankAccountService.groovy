package io.github.joxebus.services

import io.github.joxebus.beans.BankAccount
import io.github.joxebus.exceptions.BankAccountException

class BankAccountService {

    def deposit(BankAccount account, BigDecimal amout){
        account.setAmount(account.getAmount().add(amout))
    }

    def withdraw(BankAccount account, BigDecimal amount){
        if(amount > account.amount){
            throw new BankAccountException("There is no enough money " +
                    "in the account to perform the operation")
        }
        account.setAmount(account.getAmount().subtract(amount))
    }

    def balance(BankAccount account){
        account.getAmount()
    }
}
