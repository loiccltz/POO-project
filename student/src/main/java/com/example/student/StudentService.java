package com.example.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public void addStudent(Student student) {
        student.setStudentID(nextId++);
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getStudentID() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
