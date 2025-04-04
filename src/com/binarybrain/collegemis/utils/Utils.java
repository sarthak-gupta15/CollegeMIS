package com.binarybrain.collegemis.utils;

import java.sql.*;

public class Utils {
    Connection con= null;

    public  Utils(Connection con)
    {
        this.con = con;
    }

    public void printDB(String tableName)
    {
        try{
            String sql = "select * from "+tableName;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1,tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
//             System.out.println("resultSet "+resultSet.toString());
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            System.out.println("column 1 name "+ resultSetMetaData.getColumnName(1));
            while(resultSet.next())
            {
                for(int i =1; i<=count; i++)
                {
                    System.out.println(resultSetMetaData.getColumnName(i)+" : "+resultSet.getString(i));
                }
            }

        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
