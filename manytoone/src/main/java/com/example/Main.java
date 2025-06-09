package com.example;
import com.example.services.IStudentService;
import com.example.services.StudentService;
import com.example.pojo.Student;
public class Main {
    public static void main(String[] args) {
        IStudentService studentService = new StudentService();
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john.doe@example.com");
        student.setPhone("1234567890");
        studentService.addStudent(student);

    }
}