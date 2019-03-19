package com.ibm.devops;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	public static Connection getDBConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://devops-db.c0iyibgfkhqv.us-east-1.rds.amazonaws.com:3306/DEVOPS_DB", "sunil", "passw0rd");

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}

}