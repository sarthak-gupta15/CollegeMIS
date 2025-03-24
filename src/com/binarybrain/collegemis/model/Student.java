package com.binarybrain.collegemis.model;

import com.binarybrain.collegemis.utils.Gender;
import com.binarybrain.collegemis.utils.Status;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Student {
    private int id;
    private String name;
    private int rollNo;
    private String branch;
    private int mob;
    private int yearOfCompletion;
    private Status status;
    private Gender gender;
    LocalDate dateOfAddmision;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getMob() {
        return mob;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public int getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(int yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfAddmision() {
        return dateOfAddmision;
    }

    public void setDateOfAddmision(LocalDate dateOfAddmision) {
        this.dateOfAddmision = dateOfAddmision;
    }

    public Student(int id, String name, int rollNo, String branch, int mob, int yearOfCompletion, Status status, Gender gender, LocalDate dateOfAddmision) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.mob = mob;
        this.yearOfCompletion = yearOfCompletion;
        this.status = status;
        this.gender = gender;
        this.dateOfAddmision = dateOfAddmision;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", branch='" + branch + '\'' +
                ", mob=" + mob +
                ", yearOfCompletion=" + yearOfCompletion +
                ", status=" + status +
                ", gender=" + gender +
                ", dateOfAddmision=" + dateOfAddmision +
                '}';
    }

    //    public static void main(String[] args) throws ParseException {
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-16");
//        LocalDate date2 = LocalDate.now();
//        LocalDate date3 = LocalDate.of(2014, 02,16);
//        System.out.println("date "+date);
//        System.out.println("date "+date2);
//        System.out.println("date "+date3);
//    }
//    public Student ()
//    {
//
//    }
}
