package com.iwinner.web.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.spi.resource.Singleton;

@Produces("application/xml")
@Path("customersServiceRes")
@Singleton
@XmlRootElement(name = "customers")
public class CustomerResource {

	private TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();

	public CustomerResource() {
		// hardcode a single customer into the database for demonstration
		// purposes
		Customer customer = new Customer();
		customer.setName("Harold Abernathy");
		customer.setAddress("Sheffield, UK");
		customer.setId(10);
		addCustomer(customer);
		Customer customer2 = new Customer();
		customer2.setName("KL");
		customer2.setAddress("MY");
		customer2.setId(12);
		addCustomer(customer2);

	}

	@GET
	@Path("testList")
	@XmlElement(name = "customer")
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(customerMap.values());
		return customers;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getCustomer(@PathParam("id") int cId) {
		Customer customer = customerMap.get(cId);
		return "{\"name\": \" " + customer.getName() + " \", \"address\": \""
				+ customer.getAddress() + "\"}";

	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String addCustomer(Customer customer) {
		// insert
		int id = customerMap.size();
		customer.setId(id);
		customerMap.put(id, customer);
		// get inserted
		Customer result = customerMap.get(id);

		return "{\"id\": \" " + result.getId() + " \", \"name\": \" "
				+ result.getName() + " \", \"address\": \""
				+ result.getAddress() + "\"}";
	}
	@GET
	@Path("/addGet")
	@Produces(MediaType.APPLICATION_JSON)
	public String addCustomerGET(Customer customer) {
		// insert
		int id = customerMap.size();
		customer.setId(id);
		customerMap.put(id, customer);
		// get inserted
		Customer result = customerMap.get(id);

		return "{\"id\": \" " + result.getId() + " \", \"name\": \" "
				+ result.getName() + " \", \"address\": \""
				+ result.getAddress() + "\"}";
	}
}