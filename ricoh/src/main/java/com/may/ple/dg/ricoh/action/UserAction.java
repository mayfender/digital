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

import com.may.ple.dg.ricoh.criteria.CommonCriteriaResp;
import com.may.ple.dg.ricoh.criteria.PersistUserCriteriaReq;
import com.may.ple.dg.ricoh.criteria.ProfileUpdateCriteriaReq;
import com.may.ple.dg.ricoh.criteria.UserSearchCriteriaResp;
import com.may.ple.dg.ricoh.entity.User;
import com.may.ple.dg.ricoh.exception.CustomerException;
import com.may.ple.dg.ricoh.service.UserService;

@Component
@Path("user")
public class UserAction {
	private static final Logger LOG = Logger.getLogger(UserAction.class.getName());
	@Autowired
	private UserService service;
	
	public UserAction() {}
	
	@GET
	@Path("/findUserAll")
	@Produces(MediaType.APPLICATION_JSON)
	public UserSearchCriteriaResp findUserAll() {
		LOG.debug("Start");
		UserSearchCriteriaResp resp = new UserSearchCriteriaResp();
		
		try {
			List<User> users = service.findAllUser();
			resp.setUsers(users);
		} catch (Exception e) {
			resp.setStatusCode(100);
			LOG.error(e.toString());
		}
		
		LOG.debug("End");
		return resp;
	}
	
	@GET
	@Path("/deleteUser")
	public UserSearchCriteriaResp deleteUser(@QueryParam("userId")Long userId) {
		LOG.debug("Start");
		UserSearchCriteriaResp resp;
		
		try {
			LOG.debug("userId : " + userId);
			service.deleteUser(userId);
			resp = findUserAll();
		} catch (Exception e) {
			resp = new UserSearchCriteriaResp(100);
			LOG.error(e.toString());
		}
		
		LOG.debug("End");
		return resp;
	}
	
	@POST
	@Path("/saveUser")
	public CommonCriteriaResp saveUser(PersistUserCriteriaReq req) {
		LOG.debug("Start");
		CommonCriteriaResp resp = new CommonCriteriaResp() {};
		
		try {
			LOG.debug(req);
			service.saveUser(req);
		} catch (CustomerException cx) {
			resp.setStatusCode(cx.errCode);
			LOG.error(cx.toString());
		} catch (Exception e) {
			resp.setStatusCode(100);
			LOG.error(e.toString());
		}
		
		LOG.debug("End");
		return resp;
	}
	
	@POST
	@Path("/updateUser")
	public CommonCriteriaResp updateUser(PersistUserCriteriaReq req) {
		LOG.debug("Start");
		CommonCriteriaResp resp = new CommonCriteriaResp() {};
		
		try {
			LOG.debug(req);
			service.updateUser(req);
		} catch (CustomerException cx) {
			resp.setStatusCode(cx.errCode);
			LOG.error(cx.toString());
		} catch (Exception e) {
			resp.setStatusCode(100);
			LOG.error(e.toString());
		}
		
		LOG.debug("End");
		return resp;
	}
	
	@POST
	@Path("/updateProfile")
	public CommonCriteriaResp updateProfile(ProfileUpdateCriteriaReq req) {
		LOG.debug("Start");
		CommonCriteriaResp resp = new CommonCriteriaResp() {};
		
		try {
			LOG.debug(req);
			service.updateProfile(req);
		} catch (CustomerException cx) {
			resp.setStatusCode(cx.errCode);
			LOG.error(cx.toString());
		} catch (Exception e) {
			resp.setStatusCode(100);
			LOG.error(e.toString());
		}
		
		LOG.debug("End");
		return resp;
	}

}
