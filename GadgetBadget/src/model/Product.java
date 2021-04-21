package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
	
	
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
			public String insertProduct(String name, String date, String details, String category) {
				Connection con = connect();
				String output = "";
				if (con == null) {
					return "Error while connecting to the database";
				}
				
				// create a prepared statement
				String query = " insert into products (`ProductID`,`ProductName`,`ProductDate`,`ProductDetails`,`ProductCategory`)"
						+ " values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt;
				try {
					preparedStmt = con.prepareStatement(query);

					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, name);
					preparedStmt.setString(3, date);
					preparedStmt.setString(4, details);
					preparedStmt.setString(5, category);

					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
					
				} catch (SQLException e) {
					output = "Error while inserting";
					System.err.println(e.getMessage());
				}
				


				return output;
			}
			

			public String readProducts()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Product Name</th><th>Product Email</th>" +
			 "<th>Product Contact</th>" +
			 "<th>Product Type</th>" +
			 "<th>Update</th><th>Remove</th></tr>";

			 String query = "select * from products";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			
}
