package com.may.ple.dg.ricoh.action;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.may.ple.dg.ricoh.criteria.UserSearchCriterial;
import com.may.ple.dg.ricoh.entity.User;
import com.may.ple.dg.ricoh.repository.UserRepository;

@Component
@Path("user")
public class UserAction {
	private static final Logger LOG = Logger.getLogger(UserAction.class.getName());
	@Autowired
	private UserRepository userRepository;
	
	public UserAction() {}
	
	@GET
	@Path("/findUserAll")
	@Produces(MediaType.APPLICATION_JSON)
	public UserSearchCriterial findUserAll() {
		LOG.debug("Start");
		UserSearchCriterial criterial = new UserSearchCriterial();
		List<User> users = userRepository.findByStatus(1);
		for (User user : users) {
			user.setRoles(null);
		}
		criterial.setUsers(users);
		
		LOG.debug(criterial);
		
		LOG.debug("End");
		return criterial;
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
