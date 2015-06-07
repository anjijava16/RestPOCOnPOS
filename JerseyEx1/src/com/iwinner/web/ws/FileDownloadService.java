package com.iwinner.web.ws;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {

	String path = "E:/Tech_Learn/SanthuProject/SecureCareService.jar";

	@GET
	@Path("/data")
	@Produces("text/plain")
	public Response getCustomerDataFile() {
		File file = new File(path);
		ResponseBuilder rsp = Response.ok((Object) file);
		rsp.header("Content-Disposition",
				"attachment; filename=http-2.2.1.jar");
		return rsp.build();
	}
}
