package model;
import java.sql.*;


public class Customer {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget",
			 "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
			 
			 
			 


		// insert method
				public String insertcustomer(String name, String email, String type, String contact) {
					Connection con = connect();
					String output = "";
					if (con == null) {
						return "Error while connecting to the database";
					}
				}
}

