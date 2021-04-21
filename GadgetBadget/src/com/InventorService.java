package com;

import javax.ws.rs.GET;
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
	
	
}
