package com.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a student entity.
 */
@Entity
@Table(name = "jpa_student")
public class Student {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 11)
    private String code;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private int age;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

  
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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

}
