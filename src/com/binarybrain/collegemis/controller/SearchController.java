package com.binarybrain.collegemis.controller;

import com.binarybrain.collegemis.utils.Utils;

import java.sql.Connection;

public class SearchController extends Utils {

    Connection con;
    public  SearchController(Connection con)
    {
        super(con);
        this.con = con;
    }

}
