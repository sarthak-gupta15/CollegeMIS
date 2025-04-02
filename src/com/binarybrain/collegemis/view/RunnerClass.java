package com.binarybrain.collegemis.view;

import com.binarybrain.collegemis.controller.FeesController;
import com.binarybrain.collegemis.controller.GradesController;
import com.binarybrain.collegemis.controller.StudentController;
import com.binarybrain.collegemis.utils.DBConnect;

import java.sql.Connection;
import java.util.Scanner;

public class RunnerClass {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to college Management Portal\n\n");

        Connection con = DBConnect.connectDB();
        StudentController studentController  = new StudentController(con);
        FeesController feesController = new FeesController(con);


       while(true)
       {
//
           System.out.println("1. Create the record for the student");
           System.out.println("2. Create fees record with Student Id");
//           System.out.println("3. Print Database");
//           System.out.println("4. Add Grades with Student Id");
           System.out.println("3. Exit");
           System.out.println("enter the option number");
           int choice = scNum.nextInt();
           switch (choice){
               case 1:
                   studentController.createStudentRecord(con);
                   break;
               case 2:

                   feesController.createFeesRecord();
                  break;
//                   case 3:
//                       System.out.println("enter the database you want to print (Student , fees, Grades)");
//                       String input = scStr.nextLine();
//                       input = input.toUpperCase();
//                       switch (input)
//                       {
//                           case "STUDENT":
//                               System.out.println("\nbelow is the students data \n");
//                               System.out.println(StudentController.studentsData);
//                               System.out.println("successfully fetch all student data....\n");
//                               break;
//                               case "FEES":
//                                   System.out.println("\nbelow is the students fees data \n");
//                                   System.out.println(FeesController.feesData);
//                                   System.out.println("successfully fetch all student fees data....\n");
//                               break;
//                               case "GRADES":
//                                   System.out.println("\nbelow is the students grades data \n");
//                                   System.out.println(GradesController.gradesData);
//                                   System.out.println("successfully fetch all student grades data....\n");
//                           default:
//                               System.out.println("please select valid input");
//                       }
//
//                   break;
//                   case 4:
//                        System.out.println("enter student id ");
//                          int studentId1 = scNum.nextInt();
//                          gradesController.createFeesRecord(studentId1);
//                   break;
                    case 3:
                   System.out.println("Exiting...");
                   System.exit(0);
//
               default:
                   System.out.println("Please Select from above given option only");
           }
       }
    }
}
