package io.github.joxebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = GroovyTemplateAutoConfiguration.class)
@RestController
public class App {

    @GetMapping("/")
    public String home(){
        return "Welcome to Groovy Challenge";
    }

    public static void main(String... args){
        SpringApplication.run(App.class, args);
    }
}
