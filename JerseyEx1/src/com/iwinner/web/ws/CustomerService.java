package com.iwinner.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("customersSe")
public class CustomerService {

	@GET
	@Path("/local")
	@Produces("text/html")
	public Response getLocalCustomer() {
		String message = "I am Local Customer";
		return Response.ok(message).build();

	}
	@GET
	@Path("/nri")
	@Produces("text/html")
	public Response getNRICustomer() {
		String message = "I am NRI Customer";
		return Response.ok(message).build();

	}

	@GET
	@Produces("text/html")
	public Response getTestCustomer() {
		String message = "I am Dev Customer";
		return Response.status(200).entity(message).build();

	}
}
