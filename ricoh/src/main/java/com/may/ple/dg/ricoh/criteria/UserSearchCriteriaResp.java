package com.may.ple.dg.ricoh.criteria;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.may.ple.dg.ricoh.entity.Users;

public class UserSearchCriteriaResp extends CommonCriteriaResp {
	private List<Users> users;
	
	public UserSearchCriteriaResp() {}
	
	public UserSearchCriteriaResp(int statusCode) {
		super(statusCode);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
}
