package com.example.student;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int StudentID;
    private int age;
    private ArrayList<Integer> grades;

    public String getName(){
        return this.name;
    }

    public int getStudentID(){
        return this.StudentID;
    }

    public void setStudentID(int id) {
        this.StudentID = id;
    }

    public int getAge(){
        return this.age;
    }


    public ArrayList<Integer> getGrades(){
        return this.grades;
    }

    public Student() {
        this.name = "Pierre";
        this.age = 17;
        this.StudentID = 1;
        this.grades = new ArrayList<Integer>();
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>();
    }



    public ArrayList<Integer> addGrade(int grade){

        grades.add(grade);

        return grades;
    }

    public int getAverageGrades(){

        int somme = 0;
        int moyenne = 0;
        for(int i = 0; i < grades.size(); i++)
        somme += grades.get(i);
    
       
        moyenne = somme / grades.size(); 
     

        return  moyenne;
    }

    public static void main(String[] args) {
    Student eleve = new Student("loic", 40, 1);
    Student eleve2 = new Student("theo", 30, 2);
    System.out.println(eleve.name);
    System.out.println(eleve.age);
    System.out.println(eleve.StudentID);
    System.out.println(eleve.addGrade(28));

    System.out.println(eleve2.name);
    System.out.println(eleve2.age);
    System.out.println(eleve2.StudentID);
    //eleve2.addGrade(32);
    //eleve2.addGrade(30);
    eleve2.addGrade(28);
    eleve2.addGrade(20);
    eleve2.addGrade(19);
    System.out.println(eleve2.grades);
    System.out.println(eleve2.getAverageGrades());
       
}


}