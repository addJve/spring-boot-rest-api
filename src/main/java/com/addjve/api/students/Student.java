package com.addjve.api.students;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dob;

    public Student() {
    }

    public Student(String name,String email, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Long getId() {
        return id;
    }

    public int getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
