package com.example.repositories;

import java.util.List;
import com.example.dao.StudentDAO;
import com.example.Pojo.Student;

public class StudentRepository implements IStudentRepository {
    private StudentDAO studentDAO = null;
    public StudentRepository(String persistence) {
        studentDAO = new StudentDAO(persistence);
    }
    // Implement the methods from IStudentRepository interface
    @Override
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        // Logic to get student by ID
        return null; // Placeholder return
    }

    @Override
    public void updateStudent(Student student) {
        // Logic to update student
    }

    @Override
    public void deleteStudent(int id) {
        // Logic to delete student by ID
    }

    @Override
    public List<Student> getAllStudents() {
        // Logic to get all students
        return null; // Placeholder return
    }

}
