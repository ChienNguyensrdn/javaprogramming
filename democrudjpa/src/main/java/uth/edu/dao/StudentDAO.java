package uth.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

import uth.edu.pojo.Student;

public class StudentDAO {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    public StudentDAO(String persistenceName ){
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
    }
    public List<Student> getStudents(){
        entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = null;
        try{
            students = entityManager.createQuery("from Student").getResultList();
            
        }catch (Exception ex) {
            throw ex;
        }finally
        {
            entityManager.close();
        }

        return students;
    }
    public boolean save(Student student){
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }finally{
            entityManager.close();
        }
    }
}
