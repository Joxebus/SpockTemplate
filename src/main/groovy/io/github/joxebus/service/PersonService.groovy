package io.github.joxebus.service

import io.github.joxebus.beans.Person

interface PersonService {

    Person create(String name, String phone, int age)

}