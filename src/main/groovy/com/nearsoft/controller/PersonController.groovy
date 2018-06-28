package com.nearsoft.controller

import com.nearsoft.beans.Person
import com.nearsoft.service.PersonService

class PersonController {

    PersonService personService

    Person create(String name, String phone){
        personService.create(name, phone)
    }
}
