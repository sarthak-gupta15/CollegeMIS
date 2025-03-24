package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.model.Fees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FeesController {

    static Scanner scNum = new Scanner(System.in);

    public static ArrayList<Fees> feesData = new ArrayList<>(Arrays.asList(
            new Fees[]
            {
                    (new Fees(1, 1, 50000, 2000, 48000))
            } // array
            ) // method aslist
    );// arraylist constructor
    Fees createFeesRecord(int studentId)
    {
        Fees fees = new Fees(studentId, studentId, 50000,0,50000);
        feesData.add(fees);
        return new Fees(studentId, studentId, 50000,0,50000);
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
}
