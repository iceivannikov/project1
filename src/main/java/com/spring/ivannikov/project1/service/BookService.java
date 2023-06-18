package com.spring.ivannikov.project1.service;

import com.spring.ivannikov.project1.dao.BookDAO;
import com.spring.ivannikov.project1.entity.Book;
import com.spring.ivannikov.project1.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    public Person findPersonForBook(Long id) {
        Optional<Person> optionalPerson = bookDAO.findPersonForBook(id);
        Person person = null;
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
        }
        return person;
    }

    public void save(Book book) {
        bookDAO.save(book);
    }

    public Book showBook(Long id) {
        Optional<Book> optionalBook = bookDAO.showBook(id);
        Book book = null;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    public void updateBook(Book book, Long id) {
        String author = book.getAuthor();
        String name = book.getName();
        Integer yearOfPublishing = book.getYearOfPublishing();
        bookDAO.updateBook(author, name, yearOfPublishing, id);
    }

    public void deleteBook(Long id) {
        bookDAO.deleteBook(id);
    }

    public void release(Long id) {
        bookDAO.release(id);
    }

    public void assign(Long id, Person person) {
        bookDAO.assign(id, person);
    }
}
