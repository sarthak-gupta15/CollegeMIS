package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Fees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FeesController {

    static Scanner scNum = new Scanner(System.in);
    Connection con = null;
public FeesController(Connection con)
{
    this.con = con;
    createFeesTable(con);
}

    public static ArrayList<Fees> feesData = new ArrayList<>(Arrays.asList(
            new Fees[]
            {
                    (new Fees(1, 1, 50000, 2000, 48000))
            } // array
            ) // method aslist
    );// arraylist constructor
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

    public void updateFeesRecord(int studentId)
    {
        boolean flag = true;
        System.out.println("enter the amount you will pay ");
        int amountToBePaid = scNum.nextInt();

        for (Fees i : feesData)
        {
            if(i.getStudentId() == studentId)
            {
                System.out.println("previous fees " + i);
                int paidFees =  i.getPaidFees();
                int totalFees = i.getTotalFees();

                paidFees += amountToBePaid;

                int unpaid = totalFees -paidFees;

                i.setPaidFees(paidFees);
                i.setUnPaidFees(unpaid);
                System.out.println("Updated fees " + i);
                flag = false;
            }
        }

        if(flag)
        {
            System.out.println("invalid student id");
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
