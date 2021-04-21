package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Inventor;

@Path("/Inventors")
public class InventorService {
	
	Inventor inventorObj = new Inventor();
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readInventors()
	  {
	  return inventorObj.readInventors();
	  }
	
	
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertInventor(@FormParam("InventorName") String InventorName,
	  @FormParam("InventorEmail") String InventorEmail,
	  @FormParam("InventorContact") String InventorContact,
	  @FormParam("InventorType") String InventorType)
	 {
	  String output = inventorObj.insertInventor(InventorName, InventorEmail,InventorContact, InventorType);
	 return output;
	 }
	 
}
