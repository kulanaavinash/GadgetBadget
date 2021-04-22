package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Approvement {

			
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
				public String insertCustomer(String name, String email, String type, String contact) {
					Connection con = connect();
					String output = "";
					if (con == null) {
						return "Error while connecting to the database";
					}

					// create a prepared statement
					String query = " insert into customers (`CustomerID`,`CustomerName`,`CustomerEmail`,`CustomerType`,`CustomerContact`)"
							+ " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt;
					try {
						preparedStmt = con.prepareStatement(query);

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
				
				// insert method
				public String insertApprovement(String status, String date, String details, String endorser) {
					Connection con = connect();
					String output = "";
					if (con == null) {
						return "Error while connecting to the database";
					}
					
					// create a prepared statement
					String query = " insert into approvements (`ApproveID`,`ApproveStatus`,`ApproveDate`,`ApproveDetails`,`Endorser`)"
							+ " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt;
					try {
						preparedStmt = con.prepareStatement(query);

						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, status);
						preparedStmt.setString(3, date);
						preparedStmt.setString(4, details);
						preparedStmt.setString(5, endorser);

						preparedStmt.execute();
						con.close();
						output = "Inserted successfully";
						
					} catch (SQLException e) {
						output = "Error while inserting";
						System.err.println(e.getMessage());
					}
					
					

					return output;
				}
				
			

				public String readApprovements()
				 {
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>Approve Status</th><th>Approve Date</th>" +
				 "<th>Approve Details</th>" +
				 "<th> Endorser Type</th>" +
				 "<th>Update</th><th>Remove</th></tr>";

				 String query = "select * from approvements";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 // iterate through the rows in the result set
				 while (rs.next())
				 {
				 String ApproveID = Integer.toString(rs.getInt("ApproveID"));
				 String ApproveStatus = rs.getString("ApproveStatus");
				 String ApproveDate = rs.getString("ApproveDate");
				 String ApproveDetails = rs.getString("ApproveDetails");
				 String Endorser = rs.getString("Endorser");
				 
				 
				 // Add into the html table
				 output += "<tr><td>" + ApproveStatus + "</td>";
				 output += "<td>" + ApproveDate + "</td>";
				 output += "<td>" + ApproveDetails + "</td>";
				 output += "<td>" + Endorser + "</td>";
				 		
				// buttons
				 
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='items.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
				 + "<input name='ApproveID' type='hidden' value='" + ApproveID
				 + "'>" + "</form></td></tr>";
				 }
				 con.close();
				 
				 // Complete the html table
				 output += "</table>";
				 }
				 catch (Exception e)
				 {
				 output = "Error while reading the Approvements .";
				 System.err.println(e.getMessage());
				 }
				 return output;
				 }
				
				
				public String updateApprovement(String ID, String status, String date, String details, String endorser)
				
				 {
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 // create a prepared statement
				 
				 
				 String query = " update approvements set ApproveStatus= ? , ApproveDate = ? , ApproveDetails = ? , Endorser = ?  where ApproveID = ? ";
					
				 PreparedStatement preparedStmt = con.prepareStatement(query);
}






