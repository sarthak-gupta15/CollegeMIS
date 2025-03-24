package com.binarybrain.collegemis.model;

public class Fees
{

    private int id;
    private int studentId;

    private int totalFees;
    private int paidFees;
    private int unPaidFees;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }

    public int getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(int paidFees) {
        this.paidFees = paidFees;
    }

    public int getUnPaidFees() {
        return unPaidFees;
    }

    public void setUnPaidFees(int unPaidFees) {
        this.unPaidFees = unPaidFees;
    }

    public Fees(int studentId,int id,int totalFees,int paidFees,int unPaidFeesint)
    {
        this.studentId=studentId;
        this.id=id;
        this.totalFees=totalFees;
        this.paidFees=paidFees;
        this.unPaidFees=unPaidFeesint;
    }

    @Override
    public String toString() {
        return "Fees{" +
                "studentId=" + studentId +
                ", id=" + id +
                ", totalFees=" + totalFees +
                ", paidFees=" + paidFees +
                ", unPaidFees=" + unPaidFees +
                '}';
    }
}

