package com.example.student;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/{id}/graduate")
    public String checkGraduation(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        if (student.getAverageGrades() >= 12) {
            System.err.println(student.getName() + "peut passer son année");
            return student.getName() + " peut passer son année";
        } else {
            System.err.println(student.getName() + "ne peut pas passer son année");
            return student.getName() + "ne peut pas passer son année";
        }
    }
}