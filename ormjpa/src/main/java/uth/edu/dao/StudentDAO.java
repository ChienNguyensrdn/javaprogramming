package uth.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
// import java.lang.management.ManagementFactory; // Removed unnecessary import
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import org.hibernate.engine.spi.ManagedEntity;

import uth.edu.pojo.Student;
public class StudentDAO {
    private static EntityManager managedEntity;
    private static EntityManagerFactory managementFactory;
    public StudentDAO(String pesisName) {
        // Initialize the DAO, possibly setting up a connection to the database
        // or initializing any required resources.
        managementFactory = Persistence.createEntityManagerFactory(pesisName);
    }
    //CRUD object Student
    public void createStudent(Student student) {
        
        try{
            managedEntity = managementFactory.createEntityManager();
            managedEntity.getTransaction().begin();
            managedEntity.persist(student);
            managedEntity.getTransaction().commit();
        } catch (Exception e) {
            if (managedEntity.getTransaction().isActive()) {
                managedEntity.getTransaction().rollback();
            }
            e.printStackTrace(); // Handle exception appropriately
        } finally {
            managedEntity.close();
        }
    }
    public List<Student> getAllStudents() {
        // Logic to read all students from the database
        // This would typically involve using an EntityManager to query the database
        try{
            managedEntity = managementFactory.createEntityManager();
            return managedEntity.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        } finally {
            if (managedEntity != null && managedEntity.isOpen()) {
                managedEntity.close();
            }
        }
        return null; // Placeholder return statement
    }
    public Student getStudentById(String studentId) {
        // Logic to read a student by ID from the database
        try{
            managedEntity = managementFactory.createEntityManager();
            return managedEntity.find(Student.class, studentId);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        } finally {
            if (managedEntity != null && managedEntity.isOpen()) {
                managedEntity.close();
            }
        }
        return null; // Placeholder return statement
    }
    public void updateStudent(Student student) {
        // Logic to update a student in the database
        try{
            managedEntity = managementFactory.createEntityManager();
            managedEntity.getTransaction().begin();
            managedEntity.merge(student);
            managedEntity.getTransaction().commit();
        } catch (Exception e) {
            if (managedEntity.getTransaction().isActive()) {
                managedEntity.getTransaction().rollback();
            }
            e.printStackTrace(); // Handle exception appropriately
        } finally {
            managedEntity.close();
        }
    }
    public void deleteStudent(String studentId) {
        // Logic to delete a student from the database
        try{
            managedEntity = managementFactory.createEntityManager();
            managedEntity.getTransaction().begin();
            Student student = managedEntity.find(Student.class, studentId);
            if (student != null) {
                managedEntity.remove(student);
            }
            managedEntity.getTransaction().commit();
        } catch (Exception e) {
            if (managedEntity.getTransaction().isActive()) {
                managedEntity.getTransaction().rollback();
            }
            e.printStackTrace(); // Handle exception appropriately
        } finally {
            managedEntity.close();
        }
    }
    public void close() {
        // Close the EntityManagerFactory when done
        if (managementFactory != null && managementFactory.isOpen()) {
            managementFactory.close();
        }
    }
 }

