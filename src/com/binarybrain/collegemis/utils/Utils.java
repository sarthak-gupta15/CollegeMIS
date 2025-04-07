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
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            preparedStatement.setString(1,tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
//             System.out.println("resultSet "+resultSet.toString());
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
//            resultSet.last();
            int rowcount = 0;
            if (resultSet.last()) {
                rowcount = resultSet.getRow();
                resultSet.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }
            System.out.println("row number "+rowcount);
//            resultSet.first();

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
