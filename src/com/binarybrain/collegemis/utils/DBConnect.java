package com.binarybrain.collegemis.utils;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    static Connection con = null;
    static public void connectDB()
    {

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/collegemis_bb", "postgres", "sarthak");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(con!= null) System.out.println("connection build successfully");
    }
    public void createtempTable()
    {
        try {
            Statement query = con.createStatement();
            System.out.println("data "+query.execute("create table if not exists temp (id int primary key, name varchar)"));;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertDataWithStatement(int id,String name)
    {
        try {
            Statement st = con.createStatement();
            st.execute("insert into temp values (4, 'rohit')");
//                    ""+id+", "+name+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        connectDB();
        DBConnect db = new DBConnect();
        db.createtempTable();
        db.insertDataWithStatement(2,"rohit");
    }
}
