package com.example.dao;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Pojo.Book;

public class BookDAO {
    private SessionFactory sessionFactory = null;
    private Configuration configuration = null;
    public BookDAO(String persistence) {
        configuration = new Configuration().configure(persistence);
        sessionFactory = configuration.buildSessionFactory();
    }
    public void saveBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteBook(long bookId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, bookId);
        if (book != null) {
            session.delete(book);
        }
        session.getTransaction().commit();
        session.close();
    }
    public Book getBook(long bookId) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, bookId);
        session.close();
        return book;
    }
    public List<Book> getAllBooks(int pageSize, int pageNumber) {
       
        //Xu ly paging if needed
        // int pageSize = 10; // Example page size
        // int pageNumber = 1; // Example page number
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();
        session.close();
        if (pageNumber > 0 && pageSize > 0) {
            int startIndex = (pageNumber - 1) * pageSize;
            books = books.stream().skip(startIndex).limit(pageSize).collect(Collectors.toList());
        }
        if (books.isEmpty()) {
            throw new NoResultException("No books found");
        }
        return books;
    }
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
