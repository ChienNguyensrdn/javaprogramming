package uth.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "age", nullable = false)
    private int age;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private int id;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setStudentId(int studentId) {
        this.id = studentId;
    }
}
