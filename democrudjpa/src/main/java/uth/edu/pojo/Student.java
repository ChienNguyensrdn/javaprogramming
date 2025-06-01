package uth.edu.pojo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    /**
     * The unique identifier for the student.
     */
    private int id;
    @Column(name = "last_name", nullable = true, length = 100)
    private String lastName;
    @Column(name = "mark", nullable = false)
    private float mark;
    public Student() {
    }

    public Student(int id, String lastName, float mark) {
        this.id = id;
        this.lastName = lastName;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

}
