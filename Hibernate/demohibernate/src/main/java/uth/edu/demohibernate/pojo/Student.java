package uth.edu.demohibernate.pojo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.AUTO)
    private long id ;
    @Column (name = "name", nullable = false)
    private String name;
    @Column (name = "email", nullable = false, unique = true)
    @jakarta.validation.constraints.Email
    private String email;
    @Column (name = "phone")
    private String phone;
    @Column (name = "address")
    private String address;
    @Column (name = "city")
    private String city;
    @Column (name = "state")

    private String state;
    @Column (name = "country")
    private String country;
    @Column (name = "zip")
    private String zip;
    @Column (name = "gpa")
    // @jakarta.validation.constraints.Pattern(regexp = "^(0|[1-3]?\\d(\\.\\d{1,2})?|4\\.0)$", message = "GPA must be between 0.0 and 4.0")
    private double gpa;
    public Student() {
        super();
    }
    public Student(String name, String email, String phone, String address, String city, String state, String country, String zip, double gpa) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.gpa = gpa;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    private Set<Book> books;
    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
