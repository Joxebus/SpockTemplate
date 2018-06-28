package com.nearsoft.service

import com.nearsoft.beans.Person

class PersonService {

    Person create(name, phone){
        Person person = new Person()
        person.with {
            it.name = name
            it.phone = phone
        }
        person
    }
}
