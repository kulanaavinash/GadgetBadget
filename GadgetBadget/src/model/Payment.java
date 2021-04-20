package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment {
		
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
			public String insertPayment(String date, String number, String amount, String type) {
				Connection con = connect();
				String output = "";
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " insert into payments (`PaymentID`,`PaymentDate`,`CardNumber`,`Amount`,`PaymentType`)"
						+ " values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt;
				try {
					preparedStmt = con.prepareStatement(query);

					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, date);
					preparedStmt.setString(3, number);
					preparedStmt.setString(4, amount);
					preparedStmt.setString(5, type);

					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
				} catch (SQLException e) {
					output = "Error while inserting";
					System.err.println(e.getMessage());
				}
				// binding values

				return output;
			}
	
}
