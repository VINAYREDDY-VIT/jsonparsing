/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparser;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author reddy
 */
public class dbconnection {
    static final String JDBCDRIVER="com.mysql.cj.jdbc.Driver";
    static final String DBURL = "jdbc:mysql://localhost:3306/jsonparsing";
    //database name is "jsonparsing".
    static final String USER="root";
    static final String PASS="";
    public static void add(String que,String ans,ArrayList<String> arr,String subject){
        try{
            Class.forName(JDBCDRIVER); 
            //estlablishing connection between java program and local database
            Connection con = DriverManager.getConnection(DBURL,USER,PASS);
            Statement stmt = con.createStatement();
            //inserting the data into DB
            String sql = "INSERT INTO data(subject,question,option1,option2,option3,option4,answer) VALUES ('"+subject+"','"+que+"','"+
            				arr.get(0)+"','"+arr.get(1)+"','"+arr.get(2)+"','"+arr.get(3)+"','"+ans+"')";
            //table name is "data".
            boolean set = stmt.execute(sql);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
