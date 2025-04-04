package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Fees;
import com.binarybrain.collegemis.model.Student;
import com.binarybrain.collegemis.utils.Gender;
import com.binarybrain.collegemis.utils.Status;
import com.binarybrain.collegemis.utils.Utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentController extends Utils {

    Connection con = null;
    public StudentController(Connection con)
    {
        super(con);
        this.con = con;
        createStudentTable(con);
    }

     Scanner scStr = new Scanner(System.in);
     Scanner scNum = new Scanner(System.in);

     public void createStudentRecord(Connection con)
     {
         System.out.println("enter name of student");
         String name = scStr.nextLine();
         System.out.println("enter roll number");
         int roll = scNum.nextInt();
         System.out.println("enter branch");
         String branch = scStr.nextLine();
         System.out.println("enter mob no. ");
         String mob = scStr.nextLine();
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

         try {
             PreparedStatement query = con.prepareStatement("insert into student (name, rollNo, mob, branch, gender, status, Date_of_addmission) values(?,?,?,?,?,?,?)");

//             parameter positioning
             query.setString(1, name);

                query.setString(3, mob);
                query.setString(4, branch);
                query.setString(5 , genderStr);
                query.setString(6, statusStr);
                query.setDate(7, java.sql.Date.valueOf(date));
                query.setInt(2, roll);

             if(query.executeUpdate()>0)
             {
                 System.out.println("*************************student record created successfully*************************");
             }
             else
             {
                 System.out.println("*************************student record not created*************************");
             }

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

     }

//     boolean checkStudentId(int studentId)
//     {
//         for (Student Student : studentsData)
//         {
//             if(student.getId() == studentId)
//             {
//                 return true;
//             }
//         }
//         return false;
//     }

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
