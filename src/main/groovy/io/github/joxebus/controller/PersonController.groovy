package io.github.joxebus.controller

import io.github.joxebus.beans.Person
import io.github.joxebus.service.PersonService

class PersonController {

    PersonService personService

    Person create(String name, String phone){
        personService.create(name, phone)
    }
}
