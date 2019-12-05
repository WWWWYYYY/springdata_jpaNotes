package com.mycompany.myapp.repository;

import com.mycompany.myapp.SpringdataJpaNotesApp;
import com.mycompany.myapp.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdataJpaNotesApp.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void queryByAgeAndPage() {
        List<Person> list = personRepository.queryByAgeAndPage(null, new PageRequest(0,10));
        System.out.println(list);

    }

    @Test
    public void queryByAgeAnd() {
        Person person = new Person();
        person.setName("wang");
        List<Person> list = personRepository.queryByCondition(person, new PageRequest(0,10));
        System.out.println(list);

    }
}
