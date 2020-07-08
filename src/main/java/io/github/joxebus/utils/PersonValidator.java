package io.github.joxebus.utils;

import io.github.joxebus.entity.Person;

import java.util.regex.Pattern;

public class PersonValidator {

    private static final String PHONE_REGEX = "(\\d{3})-(\\d{3})-(\\d{4})";

    public static void validate(Person person) {
        if(person == null){
            throw new IllegalArgumentException("A null person is not valid.");
        }

        validateName(person.getName());
        validateLastName(person.getLastName());
        validateAge(person.getAge());
        validatePhone(person.getPhone());
    }

    private static void validateName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("The person name is not valid.");
        }
    }

    private static void validateLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("The person last name is not valid.");
        }
    }

    private static void validateAge(int age) {
        if(age < 1 || age > 70 ){
            throw new IllegalArgumentException("The person age is not valid.");
        }
    }

    private static void validatePhone(String phone) {
        if(phone != null && !Pattern.matches(PHONE_REGEX, phone)){
            throw new IllegalArgumentException(String.format("Wrong format expected ###-###-####, but was: %s", phone));
        }
    }
}
