package com;

public class ApprovementService {
	
	//DB connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/paf_lab_03",
			 "root", "");
			 
			 
			// For testing
			System.out.print("Successfully connected"); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
