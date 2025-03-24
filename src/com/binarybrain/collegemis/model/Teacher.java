package com.binarybrain.collegemis.model;

import com.binarybrain.collegemis.utils.Gender;

import java.time.LocalDate;

public class Teacher
{
    private int id;
    String name;
    Gender gender;

    LocalDate dateOfJoining;
    int experience;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }




    public Teacher(int id, String name, Gender gender, LocalDate dateOfJoining, int experience) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfJoining=dateOfJoining;
    }
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfJoining=" + dateOfJoining +
                ", experience=" + experience +
                '}';
    }
}

