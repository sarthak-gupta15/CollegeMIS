package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Fees;
import com.binarybrain.collegemis.model.Student;
import com.binarybrain.collegemis.utils.Gender;
import com.binarybrain.collegemis.utils.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentController {

    public StudentController(Connection con)
    {
        createStudentTable(con);
    }
     Student student = new Student(1,"Pranay", 23, "BCA", 1616, 2020,(Status.ACTIVE),(Gender.MALE), LocalDate.of(2020,02,15));

     Scanner scStr = new Scanner(System.in);
     Scanner scNum = new Scanner(System.in);
     FeesController feesController = new FeesController();
     static Student[] arr = {(new Student(1,"Pranay", 23, "BCA", 1616, 2020,(Status.ACTIVE),(Gender.MALE), LocalDate.of(2020,02,15)))};
     int[] num = {1,5,6,7};

     public static ArrayList<Student> studentsData = new ArrayList<>(Arrays.asList(arr));

     public Student createStudentRecord()
     {
         System.out.println("enter a id");
         int id = scNum.nextInt();
         System.out.println("enter name of student");
         String name = scStr.nextLine();
         System.out.println("enter roll number");
         int roll = scNum.nextInt();
         System.out.println("enter branch");
         String branch = scStr.nextLine();
         System.out.println("enter mob no. ");
         int mob = scNum.nextInt();
         System.out.println("enter the year of completion");
         int yoc = scNum.nextInt();
         System.out.println("enter the status of student (Active / inActive / Completed)");
         String statusStr = scStr.nextLine();
         statusStr = statusStr.toUpperCase();
         Status status= null;
         switch (statusStr)
         {
             case "ACTIVE":
                 status = Status.ACTIVE;
                 break;
                 case "INACTIVE":
                     status = Status.INACTIVE;
                 break;
                 case "COMPLETED":
                     status = Status.COMPLETED;
                 break;

         }
         System.out.println("enter the gender of the student");
         String genderStr = scStr.nextLine();
         genderStr = genderStr.toUpperCase();
         Gender gender= null;
         switch (genderStr)
         {
             case "MALE":
                 gender = Gender.MALE;
                 break;
                 case "FEMALE":
                     gender = Gender.FEMALE;
                 break;
                 case "OTHER":
                     gender = Gender.OTHER;
                 break;
         }
//         yyyy-mm-dd .split("-") return an array
//         yyyy/mm/dd
//         year mm day
         System.out.println("enter the date of addmission in this pattern (yyyy-mm-dd)");
         String dateStr = scStr.nextLine();
         String[] array = dateStr.split("-");
         LocalDate date = LocalDate.of((Integer.parseInt(array[0])), (Integer.parseInt(array[1])), (Integer.parseInt(array[2])));
         Fees fees = feesController.createFeesRecord(id);
         Student student = new Student(id, name,roll, branch, mob,yoc, status, gender, date);
         System.out.println("student "+student);
         System.out.println("fees "+fees);
         System.out.println("student has been created successully\n");
         studentsData.add(student);
         return student;
     }

     boolean checkStudentId(int studentId)
     {
         for (Student Student : studentsData)
         {
             if(student.getId() == studentId)
             {
                 return true;
             }
         }
         return false;
     }

     public void createStudentTable(Connection con)
     {
         try {
             Statement query = con.createStatement();
             String createStudentTableQuery = "create table if not exists student (id serial primary key, " +
                     "name varchar, " +
                     "rollNo int, " +
                     "mob varchar(10), " +
                     "branch varchar, " +
                     "gender varchar, " +
                     "status varchar, " +
                     "year_of_completion date, " +
                     "Date_of_addmission date)";
//             String createStudentTableQuery1 = "CREATE TABLE employees (\n" +
//                     "    id SERIAL PRIMARY KEY,\n" +
//                     "    name VARCHAR(50),\n" +
//                     "    birthdate DATE\n" +
//                     ");";
             boolean flag = query.execute(createStudentTableQuery);
             System.out.println("flag "+flag);
             System.out.println("student table created successfully");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

     }

}
