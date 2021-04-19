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
					
					
					
					
					// create a prepared statement
					String query = " insert into customer (`CustomerID`,`CustomerName`,`CustomerEmail`,`CustomerType`,`CustomerContact`)"
							+ " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt;
					try {
						preparedStmt = con.prepareStatement(query);
						
						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, name);
						preparedStmt.setString(3, email);
						preparedStmt.setString(4, type);
						preparedStmt.setString(5, contact);
						
						
						preparedStmt.execute();
						con.close();
						output = "Inserted successfully";
					} catch (SQLException e) {
						output = "Error while inserting";
						System.err.println(e.getMessage());
					}
					

					return output;
				}
				
				public String readcustomers()
				 {
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>Customer Name</th><th>Customer Email</th>" + "<th>Customer Type</th>" + "<th>Customer Contact</th>" +  "<th>Update</th><th>Remove</th></tr>";

		
			
		 



