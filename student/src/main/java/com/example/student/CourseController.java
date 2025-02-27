package com.example.student;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final List<Course> courses = new ArrayList<>();
    private final StudentService studentService;
    private int idCounter = 1;

    public CourseController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        System.err.println("matiere ajoutée");
        course.setCourseCode(idCounter++);
        courses.add(course);
        return course;
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courses;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        for (Course c : courses) {
            if (c.getCourseCode() == id) {
                return c;
            }
        }
        System.out.println("Course with ID " + id + " not found");
        return null;
    }

    @PostMapping("/{studentId}/{courseCode}")
    public Course enrollStudent(@PathVariable int studentId, @PathVariable int courseCode) {
    
        Student student = studentService.getStudentById(studentId);

    
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode() == courseCode) {
                course = courses.get(i);
                break;
            }
        }

        if (course == null) {
            System.out.println("La matière avec le code " + courseCode + " n'a pas ete trouvée.");
            return null; 
        }

        // il faut vérif si l'etudiant est deja inscrit
        List<Student> enrolledStudents = course.getEnrolledStudents();
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getStudentID() == studentId) {
                System.out.println("L'etudiant avec l'ID " + studentId + " est deja inscrit dans ce cours.");
                return course; // on retourne pour avoir un visuel sur postman
            }
        }

        // ajouter l’etudiant au cours
        course.enrollStudent(student);

        return course;
    }

    @GetMapping("/{courseCode}/students")
    public void getEnrolledStudents(@PathVariable int courseCode) {
        Course course = null;

        for (Course c : courses) {
            if (c.getCourseCode() == courseCode) {
                course = c;
                break;
            }
        }

        if (course == null) {
            System.out.println("La matière avec le code " + courseCode + " n'a pas été trouvée");
            return;
        }

        course.getEnrolledStudents();
    }
}