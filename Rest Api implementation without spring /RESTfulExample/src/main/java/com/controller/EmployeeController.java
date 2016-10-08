package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import com.bean.Employee;
import com.dao.UserDao;

/*
 * employee number is being encoded 
 * status code=200 is success 201 is when - 1. status out of range  2. token is mismatch
 * It is assumed that we have the token so we will match the token in the header from the token in the server
 * 	
 */
@Path("/employee")
public class EmployeeController {
	/*
	 * employeeNumber is being encoded
	 */
	String employeeNumber = "1234567";

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getTrackInJSON() {

		Employee emp = new Employee();
		emp.setEmployeeNumber("1234567");
		emp.setStatus(6);

		return emp;

	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStatus(Employee emp,
			@HeaderParam("Auth-Key") String authKeyRecieved) {

		if (emp.getStatus() > 6 || emp.getStatus() < 1) {
			emp.setReason("Status invalid");
			return Response.status(Response.Status.CREATED).entity(emp).build();

		} else {
			/*
			 * Check if the employee exists Check authentication
			 */

			String authKeyServer = new String(
					Base64.encodeBase64(employeeNumber.getBytes()));

			if (authKeyRecieved.equals(authKeyServer)) {
				emp.setReason("Sucessfully Updated");
				UserDao dao = new UserDao();
				dao.updateStatus(emp.getEmployeeNumber(), emp.getStatus());
				return Response.status(Response.Status.OK).entity(emp).build();
			} else {
				emp.setReason("token mismatch");
				return Response.status(Response.Status.CREATED).entity(emp)
						.build();

			}
		}

	}

}