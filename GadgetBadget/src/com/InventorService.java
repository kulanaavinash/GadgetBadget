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

import model.Inventor;

@Path("/Inventors")
public class InventorService {

	// Getmethod
	Inventor inventorObj = new Inventor();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readInventors() {
		return inventorObj.readInventors();
	}

	// Post method
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertInventor(@FormParam("InventorName") String InventorName,
			@FormParam("InventorEmail") String InventorEmail, @FormParam("InventorContact") String InventorContact,
			@FormParam("InventorType") String InventorType) {
		String output = inventorObj.insertInventor(InventorName, InventorEmail, InventorContact, InventorType);
		return output;
	}

	// Put method
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateInventor(String inventorData) {
		// Convert the input string to a JSON object
		JsonObject inventorObject = new JsonParser().parse(inventorData).getAsJsonObject();
		// Read the values from the JSON object
		String InventorID = inventorObject.get("InventorID").getAsString();
		String InventorName = inventorObject.get("InventorName").getAsString();
		String InventorEmail = inventorObject.get("InventorEmail").getAsString();
		String InventorContact = inventorObject.get("InventorContact").getAsString();
		String InventorType = inventorObject.get("InventorType").getAsString();
		String output = inventorObj.updateInventor(InventorID, InventorName, InventorEmail, InventorContact,
				InventorType);
		return output;
	}

	// Delete Method
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteInventor(String inventorData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(inventorData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String InventorID = doc.select("InventorID").text();
		String output = inventorObj.deleteInventor(InventorID);
		return output;
	}

}
