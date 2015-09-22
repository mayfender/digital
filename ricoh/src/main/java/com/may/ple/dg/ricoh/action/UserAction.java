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
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.may.ple.dg.ricoh.criteria.UserSearchCriteria;
import com.may.ple.dg.ricoh.entity.User;
import com.may.ple.dg.ricoh.repository.UserRepository;

@Component
@Path("user")
public class UserAction {
	private static final Logger LOG = Logger.getLogger(UserAction.class.getName());
	@Autowired
	private UserRepository userRepository;
	@Autowired	
	private PasswordEncoder passwordEncoder;
	
	public UserAction() {}
	
	@GET
	@Path("/findUserAll")
	@Produces(MediaType.APPLICATION_JSON)
	public UserSearchCriteria findUserAll() {
		LOG.debug("Start");
		UserSearchCriteria criterial = new UserSearchCriteria();
		
		try {			
			List<User> users = userRepository.findAll(new Sort(Direction.ASC, "userName"));
			criterial.setUsers(users);
			
			LOG.debug(passwordEncoder.encode("123"));
			
		} catch (Exception e) {
			criterial.setStatusCode(100);
		}
		
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
		
		passwordEncoder.encode("");
		
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
