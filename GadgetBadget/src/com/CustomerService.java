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

import model.Customer;






@Path("/Customers")

public class CustomerService {
	
	
	Customer customerObj = new Customer();
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readCustomers()
	  {
	  return customerObj.readCustomers();
	  }
	
}