package com.may.ple.dg.ricoh.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* --------------: Use for native query
 * @NamedNativeQueries({ 
	@NamedNativeQuery (name = "User.findByStatus", 
				query = "select * from user where enabled = ?1", 
				resultClass = User.class)
})*/

@NamedQueries({ 
	@NamedQuery(name = "User.findByStatus", 
			query = "select u from User u where u.enabled = ?1 order by u.userName asc") 
})
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 6644354613536505474L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="username", nullable=false)
	private String userName;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	@JoinColumn(name="username", referencedColumnName="username")
	private List<Role> roles;
	@Column(name="password", nullable=false)
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDateTime;
	private int enabled;	
	
	protected User() {}
	
	public User(String userName, String password, Date createdDateTime, Date updatedDateTime, int enabled, List<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
		this.enabled = enabled;
		this.roles = roles;
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	
}
