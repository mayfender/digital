/*package com.may.ple.dg.ricoh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = -1077652018007382773L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="username", nullable=false)
	private String userName;
	@Column(nullable=false)
	private String authority;
	private String name;

	protected Role() {}
	
	public Role(String userName, String authority, String name) {
		this.userName = userName;
		this.authority = authority;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
*/