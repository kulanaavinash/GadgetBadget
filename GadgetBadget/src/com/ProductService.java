package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Product;

@Path("/Products")
public class ProductService {
	

	Product productObj = new Product();
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readProducts()
	  {
	  return productObj.readProducts();
	  }
	 
	 

	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertProduct(@FormParam("ProductName") String ProductName,
	  @FormParam("ProductDate") String ProductDate,
	  @FormParam("ProductDetails") String ProductDetails,
	  @FormParam("ProductCategory") String ProductCategory)
	 {
	  String output =productObj.insertProduct(ProductName, ProductDate,ProductDetails, ProductCategory);
	 return output;
	 }
	 
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateProduct(String productData)
	 {
	 //Convert the input string to a JSON object
	  JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();
	 //Read the values from the JSON object
	  String ProductID = productObject.get("ProductID").getAsString();
	  String ProductName = productObject.get("ProductName").getAsString();
	  String ProductDate = productObject.get("ProductDate").getAsString();
	  String ProductDetails = productObject.get("ProductDetails").getAsString();
	  String ProductCategory = productObject.get("ProductCategory").getAsString();
	  String output = productObj.updateProduct(ProductID, ProductName, ProductDate, ProductDetails, ProductCategory);
	 return output;
	 }
	 

	 @DELETE
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_XML)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String deleteProduct(String productData)
	 {
	 //Convert the input string to an XML document
	  Document doc = Jsoup.parse(productData, "", Parser.xmlParser());

	  //Read the value from the element <itemID>
	  String ProductID = doc.select("ProductID").text();
	  String output = productObj.deleteProduct(ProductID);
	 return output;
	 }
	 

}
