package com.example;

import com.example.services.IStudentService;
import com.example.Pojo.Book;
import com.example.Pojo.Student;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String persistence = "hibernate.cfg.xml";
        IStudentService studentService = new com.example.services.StudentService(persistence);
        // Create a new student
        Student student = new Student();
        student.setFullName("John Doe");
        student.setEmail("abc@gmail.com");
        student.setPhone("1234567890");
        student.setAddress("123 Main St");
        student.setDepartment("Computer Science");
        student.setYear("2023");
        // Create a new book
        Book book1 = new Book();
        book1.setTitle("Java Programming");
        book1.setAuthor("Jane Smith");
        book1.setPrice(29.99);
        book1.setPublisher("Tech Books");
        book1.setIsbn("123-4567890123");
        book1.setDescription("A comprehensive guide to Java programming.");
        Book book2 = new Book();
        book2.setTitle("Database Systems");
        book2.setAuthor("John Smith");
        book2.setPrice(39.99);  
        book2.setPublisher("Database Press");
        book2.setIsbn("987-6543210987");
        book2.setDescription("An introduction to database systems.");
        // Associate books with the student
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        student.setBooks(books);
        // Save the student and books
        studentService.saveStudent(student);
        book1.setStudent(student);
        book2.setStudent(student);
        // studentService.saveBook(book1);
    }
}