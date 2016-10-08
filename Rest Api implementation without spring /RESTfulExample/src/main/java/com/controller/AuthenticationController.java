package com.controller;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import com.bean.Credentials;

@Path("/authentication")
public class AuthenticationController {
	String username = "test";
	String password = "pass";

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response authenticateUser(Credentials credentials) {

		try {

			// Authenticate the user using the credentials provided
			String token = null;

			// Issue a token for the user
			if (authenticate(credentials.getUsername().toString(), credentials
					.getPassword().toString()) == true) {
				token = issueToken(credentials.getUsername());
				credentials.setToken(token);
			}

			// Return the token on the response
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private boolean authenticate(String username, String password) {
		if (username.equals("test") && password.equals("test")) {
			return true;
		} else {
			return false;
		}

	}

	private String issueToken(String username) {
		byte[] encodedBytes = Base64.encodeBase64(username.getBytes());
		return new String(encodedBytes);
	}
}
