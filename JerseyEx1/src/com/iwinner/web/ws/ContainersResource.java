package com.iwinner.web.ws;

import org.apache.coyote.Request;


@Path("/containers")
@Produces("application/xml")
public class ContainersResource {
	
    @Context UriInfo uriInfo;
    @Context Request request;
    
    @Path("{container}")
    public ContainerResource getContainerResource(@PathParam("container")
        String container) {
        return new ContainerResource(uriInfo, request, container);
    }
    @GET
    public Containers getContainers() {
        System.out.println("GET CONTAINERS");
        return MemoryStore.MS.getContainers();
    }    
}