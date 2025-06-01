package com.example.pojo;
import javax.persistence.*;
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    @Column(name = "first_name", nullable = false, length = 100, unique = false)
    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private float mark;
    @Column(name = "mark", nullable = false)
    public float getMark() {
        return mark;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }
    public Student() {
    }

    public Student(int id, String lastName, float mark) {
        this.id = id;
        this.lastName = lastName;
        this.mark = mark;
    }
}
