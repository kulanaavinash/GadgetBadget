package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}