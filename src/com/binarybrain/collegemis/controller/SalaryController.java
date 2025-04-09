package com.binarybrain.collegemis.controller;
import com.binarybrain.collegemis.utils.Utils;

import java.sql.*;
import java.util.Scanner;

public class SalaryController extends Utils {

    Scanner scStr = new Scanner(System.in);
    Scanner scNum = new Scanner(System.in);
    Connection con;
    public SalaryController(Connection con) {
        super(con);
        this.con = con;
        createSalaryTable();
    }

    public void createSalaryRecord() {
        System.out.println("Enter Teacher ID :");
        int employeId = scNum.nextInt();

        System.out.println("Enter base salary:");
        int baseSalary = scNum.nextInt();

        try (PreparedStatement Query = con.prepareStatement(
                "INSERT INTO salary (employeId, baseSalary) VALUES (?, ?)")) {
            Query.setInt(1, employeId);
            Query.setDouble(2, baseSalary);
            if (Query.executeUpdate() > 0) {
                System.out.println("******Salary Record created successfully*******");
            } else {
                System.out.println("*****Salary record Not Created********");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createSalaryTable() {
        try  {
            String Query = "create table if not exists salary (id serial primary key, employeId int, baseSalary int, foreign key(employeId) references teacher(id))";
            PreparedStatement preparedStatement = con.prepareStatement(Query);

            preparedStatement.executeUpdate();
            System.out.println("Salary Record Inserted Succesfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
