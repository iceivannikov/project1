package com.spring.ivannikov.project1.dao;

import com.spring.ivannikov.project1.entity.Book;
import com.spring.ivannikov.project1.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from public.person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Optional<List<Book>> findAllBookForPerson(Long id) {
       return Optional.of(jdbcTemplate.query("select * from public.book where person_id=?",
               new Object[]{id},
               new BeanPropertyRowMapper<>(Book.class)));
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into public.person (full_name, year_of_birth) values(?, ?)",
                person.getFullName(), person.getYearOfBirth());
    }

    public Optional<Person> showPerson(Long id) {
        return jdbcTemplate.query("select * from public.person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void updatePerson(String fullName, Integer yearOfBirth, Long id){
        jdbcTemplate.update("update public.person set full_name=?, year_of_birth=? where id=?",
                fullName, yearOfBirth, id);
    }



    public void deletePerson(Long id) {
        jdbcTemplate.update("delete from public.person where id=?", id);
    }
}
