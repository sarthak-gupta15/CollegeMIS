package com.binarybrain.collegemis.model;

public class Salary
{
    private int id;
    private int eId;
    private int baseSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Salary(int id,int eId,int baseSalary)
    {
        this.id=id;
        this.eId=eId;
        this.baseSalary=baseSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", eId=" + eId +
                ", baseSalary=" + baseSalary +
                '}';
    }
}

