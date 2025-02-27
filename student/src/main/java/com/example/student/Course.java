package com.example.student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int courseCode;
    private int totalHours;
    private ArrayList<Student> students;


    public String getCourseName(){
        return this.courseName;
    }

    public int getCourseCode(){
        return this.courseCode;
    }

    public void setCourseCode(int id) {
        this.courseCode = id;
    }

    public int getTotalHours(){
        return this.totalHours;
    }

    
    public Course(String courseName,int courseCode, int totalHours){
        this.courseName = courseName;
        this.totalHours = totalHours;
        this.students = new ArrayList<Student>();
    }
    

      // Méthode pour ajouter un étudiant au cours
      public void addStudent(Student student) {
        students.add(student);
    }

    public void enrollStudent(Student student) {
        students.add(student); // Ajoute l'objet Student à la liste
        System.out.println("Étudiant " + student.getName() + " ajouté au cours " + courseName);
    }

    public List<Student> getEnrolledStudents() {
        if (students.isEmpty()) {
            System.out.println("Aucun étudiant n'est inscrit au cours " + courseName);
        } else {
            System.out.println("Étudiants inscrits au cours " + courseName + " :");
            for (Student student : students) {
                System.out.println("- " + student.getName() + " (ID: " + student.getStudentID() + ")");
            }
        }
        return students;
    }


    public static void main(String[] args) {
            
    }


}
