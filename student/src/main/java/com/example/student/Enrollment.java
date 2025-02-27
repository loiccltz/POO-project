package com.example.student;

public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student students, Course course) {
        this.student = student;
        this.course = course;
    }

    public void register() {
        course.enrollStudent(student);
    }

    // Getters si besoin
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}