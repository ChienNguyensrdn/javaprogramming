package com.example.services;

import java.util.List;

import com.example.Pojo.Student;

public interface IStudentService {

    void saveStudent(Student student);

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> getAllStudents();
}
