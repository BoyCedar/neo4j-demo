package com.study;

import com.study.bean.Person;
import com.study.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Neo4jSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Neo4jSpringBootApplication.class, args);
        PersonService personService = context.getBean("personService",PersonService.class);
        Person person = new Person();
        person.setName("Eric");
        person.setAge(28);
        person.setCharacter("A");
        person.setMoney(12000.0);
        // 插入
        Person savePerson = personService.save(person);
        System.out.println(savePerson);

        // 查询
        List<Person> personList = personService.personList();
        System.out.println(personList);


    }
}
