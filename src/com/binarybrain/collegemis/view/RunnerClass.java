package com.binarybrain.collegemis.view;

import com.binarybrain.collegemis.controller.*;
import com.binarybrain.collegemis.utils.DBConnect;

import java.sql.Connection;
import java.util.Scanner;

public class RunnerClass {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to college Management Portal\n\n");

        Connection con = DBConnect.connectDB();
        StudentController studentController = new StudentController(con);
        FeesController feesController = new FeesController(con);
        TeacherController teacherController = new TeacherController(con);
        GradesController gradesController = new GradesController(con);
        SearchController searchController = new SearchController(con);

        while (true) {
//
            System.out.println("1. Create the record for the student");
            System.out.println("2. Create fees record with Student Id");
            System.out.println("3. Print Database");
            System.out.println("4. Update fees by student id");
            System.out.println("5. Create teacher Record");
            System.out.println("6. Add Grades for student");
            System.out.println("7. Exit");
            System.out.println("enter the option number");
            int choice = scNum.nextInt();
            switch (choice) {
                case 1:
                    studentController.createStudentRecord(con);
                    break;
                case 2:

                    feesController.createFeesRecord();
                    break;
                case 3:
                    System.out.println("enter the database you want to print (Student , fees, teacher, Grades, Detail_Student)");
                    String input = scStr.nextLine();
                    input = input.toUpperCase();
                    switch (input) {
                        case "STUDENT":
                            System.out.println("\nbelow is the students data \n");
                            studentController.printDB(input);
                            System.out.println("successfully fetch all student data....\n");
                            break;
                        case "FEES":
                            System.out.println("\nbelow is the students fees data \n");
                            feesController.printDB(input);
                            System.out.println("successfully fetch all student fees data....\n");
                            break;
                        case "TEACHER":
                            System.out.println("\nbelow is the All Teacher data \n");
                            teacherController.printDB(input);
                            System.out.println("successfully fetch all Teacher data....\n");
                            break;
                        case "GRADES":
                            System.out.println("\nbelow is the All Grades data \n");
                            gradesController.printDB(input);
                            System.out.println("successfully fetch all grades data....\n");
                        case "DETAIL_STUDENT":
                            System.out.println("\nbelow is the All Grades data \n");
                            String tableName = "student left join teacher on student.branch = teacher.branch";
                            searchController.printDB(tableName);
                            System.out.println("successfully fetch all grades data....\n");

                        default:
                            System.out.println("please select valid input");
                    }

                    break;
                case 4:
                    System.out.println("enter student id ");
                    int studentId1 = scNum.nextInt();
                    feesController.updateFeesByStudentId(studentId1);
                    break;
                case 5:
                    teacherController.createTeacherRecord();
                    break;
                case 6:
                    System.out.println("grades comming soon...");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
//
                default:
                    System.out.println("Please Select from above given option only");
            }
        }
    }
}
