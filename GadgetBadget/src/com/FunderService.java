package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FunderService {
	
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
				public String insertFunder(String name, String email, String contact, String type) {
					Connection con = connect();
					String output = "";
					if (con == null) {
						return "Error while connecting to the database";
					}
	
					
					// create a prepared statement
					String query = " insert into funders (`FunderID`,`FunderName`,`FunderEmail`,`FunderContact`,`FunderType`)"
							+ " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt;
					try {
						preparedStmt = con.prepareStatement(query);

						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, name);
						preparedStmt.setString(3, email);
						preparedStmt.setString(4, contact);
						preparedStmt.setString(5, type);

						preparedStmt.execute();
						con.close();
						output = "Inserted successfully";
					} catch (SQLException e) {
						output = "Error while inserting";
						System.err.println(e.getMessage());
					}
					

					return output;
				}
	
