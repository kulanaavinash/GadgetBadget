package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	 
	 
	 
	 
	 
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertApprovement(@FormParam("ApproveStatus") String ApproveStatus,
	  @FormParam("ApproveDate") String ApproveDate,
	  @FormParam("ApproveDetails") String ApproveDetails,
	  @FormParam("Endorser") String Endorser)
	 {
	  String output =approvementObj.insertApprovement(ApproveStatus, ApproveDate,ApproveDetails, Endorser);
	 return output;
	 }
	 
}
