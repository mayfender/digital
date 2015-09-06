package com.may.ple.dg.ricoh.restserv;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Path("user")
public class UserAction {
	private static final Logger LOG = Logger.getLogger(UserAction.class.getName());
	
	public UserAction() {}
	
	@GET
	@Path("/getUser")
	public String getUser() {
		LOG.debug("Start");
		LOG.debug("End");
		return "OK Success!!";
	}
	
	@GET
	@Path("/findUser")
	public String findUser(@QueryParam("userId")String userId) {
		LOG.debug("Start");
		LOG.debug("End");
		return "";
	}
	
	@POST
	@Path("/saveUser")
	public String saveUser(String userId) {
		LOG.debug("Start");
		LOG.debug("End");
		return "";
	}
	
	@POST
	@Path("/updateUser")
	public String updateUser(String userId) {
		LOG.debug("Start");
		LOG.debug("End");
		return "";
	}

}
