package com.binarybrain.collegemis.controller;
import com.binarybrain.collegemis.utils.Gender;
import com.binarybrain.collegemis.utils.Utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TeacherController extends Utils
{
    Scanner scStr = new Scanner(System.in);
    Scanner scNum = new Scanner(System.in);
    Connection con = null;

    public TeacherController(Connection con) {
        super(con);
        createTeacherTable(con);
        this.con = con;
    }

    public void createTeacherRecord() {
        System.out.println("Enter name of the teacher:");
        String name = scStr.nextLine();

        System.out.println("Enter gender (MALE / FEMALE / OTHER):");
        String genderStr = scStr.next();
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

        System.out.println("Enter the date of joining (yyyy-mm-dd):");
        String dateStr = scNum.nextLine();
        LocalDate dateOfJoining = LocalDate.parse(dateStr);

        System.out.println("Enter years of experience:");
        int experience = scNum.nextInt();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Branch :");
        String branch = "";
        branch = sc.nextLine();

        try {
            PreparedStatement query = con.prepareStatement(
                    "insert into teacher (name, gender, date_of_joining, experience, branch) VALUES (?, ?, ?, ?,?)");
            query.setString(1, name);
            query.setString(2, genderStr);
            query.setDate(3, java.sql.Date.valueOf(dateOfJoining));
            query.setInt(4, experience);
            query.setString(5, branch);

            if (query.executeUpdate() > 0) {
                System.out.println("Teacher record created successfully**** ");
            } else {
                System.out.println("**** Teacher record not created *****");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTeacherTable(Connection con) {
        try {
            Statement query = con.createStatement();
            String createTeacherTableQuery = ("CREATE TABLE IF NOT EXISTS teacher (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR, " +
                    "gender VARCHAR, " +
                    "date_of_joining DATE, " +
                    "experience INT," +
                    "branch varchar )");

            query.execute(createTeacherTableQuery);
            System.out.println("Teacher table created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}