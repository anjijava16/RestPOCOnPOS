package com.iwinner.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/localCust")
public class PathParamService {

	@GET
	@Path("{name}/{country}")
	@Produces("text/html")
	public Response getCustomerInfo(@PathParam("name")String name,@PathParam("country")String country){
		String output="Name is :"+name+ ";country="+country;
		return Response.status(200).entity(output).build();
	}
}
