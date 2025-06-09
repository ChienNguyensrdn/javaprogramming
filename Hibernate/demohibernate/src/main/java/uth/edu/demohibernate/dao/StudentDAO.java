package uth.edu.demohibernate.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    //SeesionFactory sessionFactory;
    //Session session;
    private Configuration configuration = null;
    private SessionFactory sessionFactory = null;
    public StudentDAO(String configFile) {
        configuration = new Configuration();
        configuration.configure(configFile);
        sessionFactory = configuration.buildSessionFactory();
    }
    public boolean saveStudent(uth.edu.demohibernate.pojo.Student student) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    public uth.edu.demohibernate.pojo.Student getStudent(long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(uth.edu.demohibernate.pojo.Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public boolean updateStudent(uth.edu.demohibernate.pojo.Student student) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    public boolean deleteStudent(long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            uth.edu.demohibernate.pojo.Student student = session.get(uth.edu.demohibernate.pojo.Student.class, id);
            if (student != null) {
                session.delete(student);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    
}
