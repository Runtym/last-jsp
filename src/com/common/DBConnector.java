package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static final String USER = "osfu";
	private static final String PASSWD = "12345678";
	private static final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	private static Connection con = null;
	
	public static void initDriver(){
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void open(){
		initDriver();
		try {
			con = DriverManager.getConnection(URL,USER,PASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		open();
		return con;
	}
}

