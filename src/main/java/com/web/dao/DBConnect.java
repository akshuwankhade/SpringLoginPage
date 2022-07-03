package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
    static public Connection connection = null;

    public static Connection getConnection() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wordcount","root","root");
		}
		catch(Exception e) {
			System.out.println(e);
		}
        return connection;
    }
}
