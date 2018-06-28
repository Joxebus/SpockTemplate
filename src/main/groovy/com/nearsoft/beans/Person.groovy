package com.nearsoft.beans

import groovy.transform.Canonical

/**
 * This class use a validtation with regex for telephone number
 */
@Canonical
class Person {
    String name
    int age
    String phone
    void setPhone(String phoneNumber){
        if(phoneNumber ==~ /(\d{3})-(\d{3})-(\d{4})/){
            phone = phoneNumber
        }else{
            throw new RuntimeException("$phoneNumber has an invalid format ###-###-####")
        }
    }
}
