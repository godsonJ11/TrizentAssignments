package com.jsonreader;

public class StudentsDetails {
    private int studentId;
    private String studentName;
    private int Studentage;

    public StudentsDetails(int studentId, String studentName, int studentage) {
        this.studentId = studentId;
        this.studentName = studentName;
         this.Studentage = studentage;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentage() {
        return Studentage;
    }

    public void setStudentage(int studentage) {
        Studentage = studentage;
    }



}
