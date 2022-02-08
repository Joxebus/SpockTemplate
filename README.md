# SpockTemplate
[![Build Status](https://travis-ci.com/Joxebus/SpockTemplate.svg?branch=master)](https://travis-ci.com/Joxebus/SpockTemplate)

This repo contains templates to start to work with Spock Framework.

Spock use tests written in Groovy which has been created to be companion with Java, so most of the Java code is valid for Groovy.

If you are using IntelliJIDEa open the project and select the options:

- Use auto-import
- Create directories for empty content roots automatically
- Create separate module per source set

and finally

- Use default gradle wrapper

## Structure of the project

```
root
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── src
│   └── main
│       ├── groovy
│       ├── java
│       └── resources
└── src
    └── test
        ├── groovy
        ├── java
        └── resources
```

## Requirements

- Java 8
- Gradle 7.3.3

## Run tests

For MacOS and Linux

`` ./gradlew test ``  

or for Windows

`` gradlew.bat test``
