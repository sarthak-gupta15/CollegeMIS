package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Grades;
import com.binarybrain.collegemis.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GradesController extends Utils {

//    static StudentController studentController = new StudentController();
    public GradesController(Connection con)
    {
        super(con);
        this.con = con;
        createGradesTable();
    }
    Connection con = null;
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
     static Grades grades = new Grades(1,1, Year.FIRST, Semester.SECOND, Exam_Type.REGULAR, 100, 75);

    public static Grades[] gradesArray =  { grades };

    public static ArrayList<Grades> gradesData = new ArrayList(Arrays.asList(gradesArray));

   public void createFeesRecord(int studentId )
    {
        int id=0;
        if(true)
        {
            System.out.println("Student Id is not valid");
            return;
        }
        System.out.println("enter the Year you're studying");
        String yearInput = scStr.nextLine();
        yearInput = yearInput.toUpperCase();
        Year year = null;
        switch (yearInput)
        {
            case "FIRST":
                year = Year.FIRST;
                break;
                case "SECOND":
                year = Year.SECOND;
                break;
                case "THIRD":
                year = Year.THIRD;
                break;
            case "FOURTH":
                year = Year.FOURTH;
                break;
        }
        System.out.println("enter the semester you're studying");
        String semesterInput = scStr.nextLine();
        semesterInput = semesterInput.toUpperCase();
        Semester semester = null;
        switch (semesterInput)
        {
            case "FIRST":
                semester = Semester.FIRST;
                id=1;
                break;
                case "SECOND":
                semester = Semester.SECOND;
                    id=2;
                break;
                case "THIRD":
                semester = Semester.THIRD;
                    id=3;
                break;
                case "FOURTH":
                semester = Semester.FOURTH;
                id=4;
                break;
                case "FIFTH":
                semester = Semester.FIFTH;
                break;
                case "SIXTH":
                semester = Semester.SIXTH;
                break;
                case "SEVENTH":
                semester = Semester.SEVENTH;
                break;
                case "EIGHTH":
                semester = Semester.EIGHTH;
                break;
        }
        System.out.println("enter the type of exam you're appearing for");
        String examTypeInput = scStr.nextLine();
        examTypeInput = examTypeInput.toUpperCase();
        Exam_Type examType = null;
        switch (examTypeInput)
        {
            case "REGULAR":
                examType = Exam_Type.REGULAR;
                break;
                case "MAKEUP":
                examType = Exam_Type.MAKEUP;
                break;
            case "BACK":
                examType = Exam_Type.BACK;
                break;
        }

        System.out.println("enter the total marks");
        int totalMarks = scNum.nextInt();

        System.out.println("enter the marks obtained");
        int obtainedMarks = scNum.nextInt();

        try {

            PreparedStatement Query = con.prepareStatement ( "insert into grades (StudentId, examtype, yearStudying, semester, totalMarks, obtainedMarks) values (?, ?, ?, ?, ?, ?)");
            Query.setInt(1, studentId);
            Query.setString(2, examTypeInput);
            Query.setString(3, yearInput);
            Query.setString(4, semesterInput);
            Query.setInt(5, totalMarks);
            Query.setFloat(6, obtainedMarks);

            if (Query.executeUpdate() > 0) {
                System.out.println("****Grades record created successfully**** ");
            } else {
                System.out.println("**** Grades record not created *****");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createGradesTable()
    {
        try {

            String Query = "Create table if not exists grades (id serial primary key, StudentId int, examtype varchar, yearStudying varchar, semester varchar, totalMarks int, obtainMarks float, foreign key(StudentId) references student(id))";
            PreparedStatement preparedStatement = con.prepareStatement(Query);
            preparedStatement.executeUpdate();
            System.out.println("Grades table created Succesfully");

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
