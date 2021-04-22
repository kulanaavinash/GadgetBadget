package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Approvement;

@Path("/Approvements")
public class ApprovementService {
	
	Approvement approvementObj = new Approvement();
	 @GET
	 @Path("/")
	 @Produces(MediaType.TEXT_HTML)
	 public String readApprovements()
	  {
	  return approvementObj.readApprovements();
	  }
	 
}
