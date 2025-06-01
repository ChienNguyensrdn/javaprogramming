package uth.edu;
import uth.edu.dao.StudentDAO;
import uth.edu.pojo.Student;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Student student = new Student("John Doe", 20);
        StudentDAO studentDAO = new StudentDAO("JPAs");
        studentDAO.createStudent(student);
    }
}