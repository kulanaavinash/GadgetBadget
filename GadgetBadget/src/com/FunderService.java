package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Funder;


@Path("/Funders")
public class FunderService {
	Funder funderObj = new Funder();
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	public String readFunder()
	{
		return funderObj.readFunder();
	}
	
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	public String insertFunder(
			@FormParam("FunderName") String FunderName,
			@FormParam("FunderEmail") String FunderEmail,
			@FormParam("FunderContact") String FunderContact,
			@FormParam("FunderType") String FunderType )
	{
		String output = funderObj.insertFunder(FunderName, FunderEmail, FunderContact, FunderType);
		return output;
	}
	 
		@PUT
		 @Path("/")
		 @Consumes(MediaType.APPLICATION_JSON)
		 @Produces(MediaType.TEXT_PLAIN)
		 public String updateFunder(String funderData)
		 {
		 //Convert the input string to a JSON object
		  JsonObject funderObject = new JsonParser().parse(funderData).getAsJsonObject();
		 //Read the values from the JSON object
		  String FunderID = funderObject.get("FunderID").getAsString();
		  String FunderName = funderObject.get("FunderName").getAsString();
		  String FunderEmail = funderObject.get("FunderEmail").getAsString();
		  String FunderContact = funderObject.get("FunderContact").getAsString();
		  String FunderType = funderObject.get("FunderType").getAsString();
		  String output = funderObj.updateFunder(FunderID, FunderName, FunderEmail, FunderContact, FunderType);
		  return output;
		 }
		
}