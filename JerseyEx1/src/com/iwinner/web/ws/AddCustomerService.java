package com.iwinner.web.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("addCustomersService")
public class AddCustomerService {

@POST
@Path("addCustomer")
@Consumes("text/html")
public Response addCustoemrService(@FormParam("nameKey")String name,@FormParam("countryKey")String country){
	String output = "<font face='verdana' size='2'>" +
            "Web Service has added your Customer information with Name - <u>"+name+"</u>, Country - <u>"+country+"</u></font>";
	return Response.status(200).entity(output).build();

}
}
