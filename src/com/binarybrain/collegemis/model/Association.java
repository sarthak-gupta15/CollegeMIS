package com.binarybrain.collegemis.model;

public class Association
{
    private int id;
    String branch;

    int teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Association(int id,String branch,int teacherId)
    {
        this.id=id;
        this.branch=branch;
        this.teacherId=teacherId;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}

