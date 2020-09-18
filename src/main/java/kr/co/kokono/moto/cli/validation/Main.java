package kr.co.kokono.moto.cli.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Person person = new Person("", 200);
        PersonValidator personValidator = new PersonValidator();
        if (personValidator.supports(person.getClass())) {
            BindException error = new BindException(person, "person");
            personValidator.validate(person, error);

            log.error("error.hasErrors() = " + error.hasErrors());
            log.error("" + error.getAllErrors());

        } else {
            log.error("invalid class");
        }

    }
}
