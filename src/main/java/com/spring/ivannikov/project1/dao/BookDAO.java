package com.spring.ivannikov.project1.dao;

import com.spring.ivannikov.project1.entity.Book;
import com.spring.ivannikov.project1.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> findAll() {
        return jdbcTemplate.query("select * from Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("insert into Book (author, name, year_of_publishing) values(?, ?, ?)",
                book.getAuthor(), book.getName(), book.getYearOfPublishing());
    }

    public Optional<Book> showBook(Long id) {
        return jdbcTemplate.query("select * from Book where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public void updateBook(String author, String name, Integer yearOfPublishing, Long id) {
        jdbcTemplate.update("update book set author=?, name=?, year_of_publishing=? where id=?",
                author, name, yearOfPublishing, id);
    }

    public void deleteBook(Long id) {
        jdbcTemplate.update("delete from book where id=?", id);
    }

    public Optional<Person> findPersonForBook(Long id) {
        return jdbcTemplate.query(
                "select person.* from book join person on book.person_id = person.id where book.id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void release(Long id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
    }

    public void assign(Long id, Person person) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", person.getId(), id);
    }

}
