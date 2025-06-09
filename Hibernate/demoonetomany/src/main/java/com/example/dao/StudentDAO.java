package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Pojo.Student;

public class StudentDAO {
    private SessionFactory sessionFactory = null;
    private Configuration configuration = null;
    public StudentDAO(String persistence) {
        configuration = new Configuration().configure(persistence);
        sessionFactory = configuration.buildSessionFactory();
    }
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteStudent(long studentId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        if (student != null) {
            session.delete(student);
        }
        session.getTransaction().commit();
        session.close();
    }
    public Student getStudent(long studentId) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, studentId);
        session.close();
        return student;
    }
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
