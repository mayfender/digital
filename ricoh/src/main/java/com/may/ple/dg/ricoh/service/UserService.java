/*package com.may.ple.dg.ricoh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.may.ple.dg.ricoh.constant.RolesConstant;
import com.may.ple.dg.ricoh.criteria.PersistUserCriteriaReq;
import com.may.ple.dg.ricoh.criteria.ProfileUpdateCriteriaReq;
import com.may.ple.dg.ricoh.entity.Role;
import com.may.ple.dg.ricoh.entity.User;
import com.may.ple.dg.ricoh.exception.CustomerException;
import com.may.ple.dg.ricoh.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOG = Logger.getLogger(UserService.class.getName());
	@Autowired
	private UserRepository userRepository;
	@Autowired	
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAllUser() {
		try {
			return userRepository.findAll(new Sort(Direction.ASC, "userName"));
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	public void saveUser(PersistUserCriteriaReq req) throws Exception {
		try {
			User u = userRepository.findByUserName(req.getUserName());
			if(u != null) {
				throw new CustomerException(200, "This username is existing");
			}
			
			String password = passwordEncoder.encode(new String(Base64.decode(req.getPassword().getBytes())));
			List<Role> roles = getRole(req.getUserName(), req.getAuthority());
			Date currentDate = new Date();
			
			User user = new User(req.getUserName(), password, currentDate, currentDate, req.getStatus(), roles);
			userRepository.save(user);
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	public void updateUser(PersistUserCriteriaReq req) throws Exception {
		try {
			User user = userRepository.findOne(req.getId());
			
			if(!user.getUserName().equals(req.getUserName())) {
				User u = userRepository.findByUserName(req.getUserName());
				if(u != null)
					throw new CustomerException(200, "This username is existing");
			}
			
			user.setUserName(req.getUserName());
			user.setEnabled(req.getStatus());
			user.setUpdatedDateTime(new Date());
			
			List<Role> roles = getRole(req.getUserName(), req.getAuthority());
			Role r = roles.get(0);
			
			Role role = user.getRoles().get(0);
			role.setUserName(req.getUserName());
			role.setAuthority(r.getAuthority());
			role.setName(r.getName());
			
			userRepository.save(user);
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	public void deleteUser(long userId) throws Exception {
		try {
			userRepository.delete(userId);
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	public void updateProfile(ProfileUpdateCriteriaReq req) throws Exception {
		try {
			if(!req.getNewUserName().equals(req.getOldUserName())) {
				User u = userRepository.findByUserName(req.getNewUserName());
				if(u != null)
					throw new CustomerException(200, "This username is existing");	
			}
			
			User user = userRepository.findByUserName(req.getOldUserName());
			user.setUserName(req.getNewUserName());
			user.setUpdatedDateTime(new Date());
			
			if(!StringUtils.isBlank(req.getPassword())) {
				String password = passwordEncoder.encode(new String(Base64.decode(req.getPassword().getBytes())));		
				user.setPassword(password);
			}
						
			userRepository.save(user);
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	private List<Role> getRole(String userName, String authority) throws Exception {
		RolesConstant roleConstant = RolesConstant.valueOf(authority);
		
		if(roleConstant == null)
			throw new Exception("Not found Role from authority : " + authority);
		
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role(userName, roleConstant.toString(), roleConstant.getName());
		roles.add(role);
		return roles;
	}
	
}
*/