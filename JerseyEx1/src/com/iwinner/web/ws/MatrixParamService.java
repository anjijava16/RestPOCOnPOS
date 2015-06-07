package com.iwinner.web.ws;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("matrixService")
public class MatrixParamService {

	@GET
	@Produces("text/html")
	public Response getMatrixResponse(@MatrixParam("nameKey")String name, @MatrixParam("countryKey")String country) {
		String custInfo="Name key="+name+"country="+country;
		return Response.status(200).entity(custInfo).build();

	}
}
