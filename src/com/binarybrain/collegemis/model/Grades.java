package com.binarybrain.collegemis.model;

import com.binarybrain.collegemis.utils.Exam_Type;
import com.binarybrain.collegemis.utils.Semester;
import com.binarybrain.collegemis.utils.Year;

public class Grades
{
    private int studentId;
    private int id;
    Year year;
    Semester semester;
    Exam_Type examType;
    private int totalMarks;
    private int obtainedMarks;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }


    public Exam_Type getExamType() {
        return examType;
    }

    public void setExamType(Exam_Type examType) {
        this.examType = examType;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public Grades(int studentId,int id,  Year year,Semester semester,Exam_Type examType,int totalMarks,int obtainedMarks)
    {
        this.studentId=studentId;
        this.id=id;
        this.year=year;
        this.semester=semester;
        this.examType=examType;
        this.totalMarks=totalMarks;
        this.obtainedMarks=obtainedMarks;

    }

    @Override
    public String toString() {
        return "Grades{" +
                "studentId=" + studentId +
                ", id=" + id +
                ", year=" + year +
                ", semester=" + semester +
                ", examType=" + examType +
                ", totalMarks=" + totalMarks +
                ", obtainedMarks=" + obtainedMarks +
                '}';
    }
}

