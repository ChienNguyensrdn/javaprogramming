package com.example.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.example.pojo.Student;
public class StudentDAO {
    private static EntityManager eManager;
    private static EntityManagerFactory eManagerFactory;
    public StudentDAO(String persistenceUnitName) {
        eManagerFactory = javax.persistence.Persistence.createEntityManagerFactory(persistenceUnitName);
        // eManager = eManagerFactory.createEntityManager();
    }
}
