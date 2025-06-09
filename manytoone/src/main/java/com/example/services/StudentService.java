package com.example.services;

import java.util.List;

import com.example.pojo.Student;
import com.example.repositories.IStudentRepository;
import com.example.repositories.StudentRepository;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {    
        studentRepository.deleteStudent(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.getStudentById(id);
    }
    @Override
    public List<Student> getAllStudents(int page, int pageSize) {
        return studentRepository.getAllStudents(page, pageSize);
    }
}
