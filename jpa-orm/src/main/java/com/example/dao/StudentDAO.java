package com.example.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.example.pojo.Student;
import java.util.List;
import javax.persistence.EntityManager;

public class StudentDAO {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    public StudentDAO(String persistencName){
        entityManagerFactory = Persistence.createEntityManagerFactory(persistencName);
        // entityManager = entityManagerFactory.createEntityManager();
    }
    public boolean save (Student student) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public boolean update(Student student) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public boolean delete(Long id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public Student findById(Long id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public List<Student> findAll() {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
      
}
