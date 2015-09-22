package com.may.ple.dg.ricoh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.may.ple.dg.ricoh.constant.RolesConstant;
import com.may.ple.dg.ricoh.criteria.PersistUserCriteriaReq;
import com.may.ple.dg.ricoh.entity.Role;
import com.may.ple.dg.ricoh.entity.User;
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
			String password = passwordEncoder.encode(new String(Base64.decode(req.getPassword().getBytes())));
			List<Role> roles = getRole(req.getUserName(), req.getRoleId());
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
			List<Role> roles = getRole(req.getUserName(), req.getRoleId());
			User user = userRepository.findOne(req.getId());
			user.setUserName(req.getUserName());
			user.setRoles(roles);
			user.setEnabled(req.getStatus());
			user.setUpdatedDateTime(new Date());
			
			userRepository.save(user);
		} catch (Exception e) {
			LOG.debug(e.toString());
			throw e;
		}
	}
	
	private List<Role> getRole(String userName, int roleId) throws Exception {
		RolesConstant roleConstant = RolesConstant.findById(roleId);
		
		if(roleConstant == null)
			throw new Exception("Not found Role from roleId : " + roleId);
		
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role(userName, roleConstant.toString(), roleConstant.getName());
		roles.add(role);
		return roles;
	}
	
}
