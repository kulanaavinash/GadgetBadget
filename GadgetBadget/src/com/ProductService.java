package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	 

}
