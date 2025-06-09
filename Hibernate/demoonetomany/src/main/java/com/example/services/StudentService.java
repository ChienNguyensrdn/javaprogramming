package com.example.services;

import java.util.List;

import com.example.Pojo.Student;
import com.example.repositories.IStudentRepository;
import com.example.repositories.StudentRepository;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    public StudentService(String persistence) {
        // Initialize the repository with the persistence configuration
        this.studentRepository = new StudentRepository(persistence);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

}
