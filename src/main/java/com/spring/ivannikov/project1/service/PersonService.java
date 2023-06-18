package com.spring.ivannikov.project1.service;

import com.spring.ivannikov.project1.dao.PersonDAO;
import com.spring.ivannikov.project1.entity.Book;
import com.spring.ivannikov.project1.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> findAll(){
        return personDAO.findAll();
    }

    public List<Book> findAllBookForPerson(Long id) {
        Optional<List<Book>> optionalBooks = personDAO.findAllBookForPerson(id);
        List<Book> books = null;
        if (optionalBooks.isPresent()) {
            books = optionalBooks.get();
        }
        return books;
    }

    public void save(Person person) {
        personDAO.save(person);
    }
    public void updatePerson(Person person, Long id) {
        String fullName = person.getFullName();
        Integer yearOfBirth = person.getYearOfBirth();
        personDAO.updatePerson(fullName, yearOfBirth, id);
    }

    public Person showPerson(Long id) {
        Optional<Person> optionalPerson = personDAO.showPerson(id);
        Person person = null;
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
        }
        return person;
    }

    public void deletePerson(Long id) {
        personDAO.deletePerson(id);
    }

}
