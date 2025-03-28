package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Grades;
import com.binarybrain.collegemis.utils.Exam_Type;
import com.binarybrain.collegemis.utils.Gender;
import com.binarybrain.collegemis.utils.Semester;
import com.binarybrain.collegemis.utils.Year;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GradesController {

//    static StudentController studentController = new StudentController();

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

        Grades grades = new Grades(studentId,(id*10+studentId) , year, semester, examType, totalMarks, obtainedMarks);
        gradesData.add(grades);
        System.out.println("Grades Added Successfully\n");
    }
}
