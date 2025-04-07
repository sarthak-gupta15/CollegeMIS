package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Fees;
import com.binarybrain.collegemis.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FeesController extends Utils {

    static Scanner scNum = new Scanner(System.in);
    Connection con = null;
public FeesController(Connection con)
{
    super(con);
    this.con = con;
    createFeesTable(con);
}


    public void createFeesRecord()
    {
        System.out.println("enter student Id: ");
        int studentId = scNum.nextInt();
        System.out.println("enter the total fees");
        int totalFees = scNum.nextInt();
        System.out.println("how much you want to pay");
        int paidFees = scNum.nextInt();
        int unPaidFees = totalFees- paidFees;
        if(unPaidFees<0)
        {
            System.out.println("************ you have entered wrong data ************");
            System.exit(-1);
        }
        String sql = "insert into fees(studentId , totalFees, unpaidFees, paidFees) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("record inserted.......");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFeesByStudentId(int studentId)
    {
        System.out.println("enter the amout you want to pay");
        int paidFees = scNum.nextInt();
       String sqlQuery = "update fees set paidFees = paidFees+ ? , unPaidFees = unPaidFees - ? where studentId = ?";

        try {
//            PreparedStatement preparedStatement = con.prepareStatement("update fees set paidFees = paidFees+ ? , unPaidFees = unPaidFees - ? where studentId = ?");
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,paidFees);
            preparedStatement.setInt(2,paidFees);
            preparedStatement.setInt(3,studentId);
            preparedStatement.executeUpdate();
            System.out.println("fees updated.....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void createFeesTable(Connection con)
    {
        String sql = "CREATE TABLE IF NOT EXISTS Fees (\n"
                + " id serial PRIMARY KEY,\n"
                + " studentId integer NOT NULL,\n"
                + " totalFees integer NOT NULL,\n"
                + " paidFees integer,\n"
                + " unPaidFees integer NOT NULL\n"
                + ");";
        try {
                PreparedStatement query = con.prepareStatement(sql);
                query.execute();
            System.out.println("Fees table created successfully....");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
