package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				

				public String readFunder()
				 {
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>Funder Name</th><th>Funder Email</th>" +
				 "<th>Funder Contact</th>" +
				 "<th>Funder Type</th>" +
				 "<th>Update</th><th>Remove</th></tr>";

				 String query = "select * from funders";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 // iterate through the rows in the result set
				 while (rs.next())
				 {
				 String FunderID = Integer.toString(rs.getInt("FunderID"));
				 String FunderName = rs.getString("FunderName");
				 String FunderEmail = rs.getString("FunderEmail");
				 String FunderContact =rs.getString("FunderContact");
				 String FunderType = rs.getString("FunderType");
				 
				 // Add into the html table
				 output += "<tr><td>" + FunderName + "</td>";
				 output += "<td>" + FunderEmail + "</td>";
				 output += "<td>" + FunderContact + "</td>";
				 output += "<td>" + FunderType + "</td>";
				

				 // buttons
				 
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='funders.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
				 + "<input name='FunderID' type='hidden' value='" + FunderID
				 + "'>" + "</form></td></tr>";
				 }
				 con.close();
				 
				// Complete the html table
				 output += "</table>";
				 }
				 catch (Exception e)
				 {
				 output = "Error while reading the funders.";
				 System.err.println(e.getMessage());
				 }
				 return output;
				 }
				
				
				public String updateFunder(String ID, String name, String email, String contact, String type)
				
				 {
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 
				 
				 // create a prepared statement
				 String query = " update funders set FunderName= ? , FunderEmail = ? , FunderContact = ? , FunderType = ?  where FunderID = ? ";
					
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 
				 // binding values
				 preparedStmt.setString(1, name);
				 preparedStmt.setString(2, email);
				 preparedStmt.setString(3, contact);
				 preparedStmt.setString(4, type);
				 preparedStmt.setInt(5, Integer.parseInt(ID));
	}
