package com.example.repositories;

import java.util.List;

import com.example.Pojo.Student;

public interface IStudentRepository {
    void saveStudent(Student student);
    Student getStudentById(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
    List<Student> getAllStudents();
}
