package com.example.services;
import java.util.List;

import com.example.pojo.Student;
public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentById(long id);
    List<Student> getAllStudents(int page, int pageSize);

}
