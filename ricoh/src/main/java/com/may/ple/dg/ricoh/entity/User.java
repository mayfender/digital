package com.may.ple.dg.ricoh.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
	@Column(name="password", nullable=false)
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="username", referencedColumnName="username")
	private List<Role> roles;
	private String password;
	private Timestamp createdDateTime;
	private Timestamp updatedDateTime;
	private int enabled;	
	
	protected User() {}
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Timestamp updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
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
	
}
