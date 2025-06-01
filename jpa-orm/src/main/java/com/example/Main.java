package com.example;
import com.example.pojo.Student;
import com.example.dao.StudentDAO;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Khoi tao Student object 
        Student student = new Student("S001", "John Doe", 20);
        // Khoi tao StudentDAO object
        StudentDAO studentDAO = new StudentDAO("JPAs");
        studentDAO.save(student);
    }
}