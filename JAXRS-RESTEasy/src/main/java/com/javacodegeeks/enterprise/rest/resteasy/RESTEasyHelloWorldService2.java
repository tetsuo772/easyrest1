package com.javacodegeeks.enterprise.rest.resteasy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/RESTEasyHelloWorld2")
public class RESTEasyHelloWorldService2 {
	
	@GET
	@Path("/{pathParameter}")
	public Response responseMsg( @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from[22]: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
 
	
	@POST
	@Path("/{pathParameter}")
	public Response response( @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
	
}
