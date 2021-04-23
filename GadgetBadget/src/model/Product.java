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

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget", "root", "");
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

	public String readProducts() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Product Name</th><th>Product Date</th>" + "<th>Product Deatils</th>"
					+ "<th>Product Category</th></tr>";

			String query = "select * from products";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String ProductID = Integer.toString(rs.getInt("ProductID"));
				String ProductName = rs.getString("ProductName");
				String ProductDate = rs.getString("ProductDate");
				String ProductDetails = rs.getString("ProductDetails");
				String ProductCategory = rs.getString("ProductCategory");

				// Add into the html table
				output += "<tr><td>" + ProductName + "</td>";
				output += "<td>" + ProductDate + "</td>";
				output += "<td>" + ProductDetails + "</td>";
				output += "<td>" + ProductCategory + "</td>";

			}
			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the products.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateProduct(String ID, String name, String date, String details, String category)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement

			String query = " update products set ProductName= ? , ProductDate = ? , ProductDetails = ? , ProductCategory = ?  where ProductID = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, date);
			preparedStmt.setString(3, details);
			preparedStmt.setString(4, category);
			preparedStmt.setInt(5, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the product.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteProduct(String ProductID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from products where ProductID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ProductID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the product.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
