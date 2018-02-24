package com.spring.entity;

import java.util.HashSet;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "user", catalog = "test")
public class User {

	private int id;
	private String username;
	private String password;
	private String state;
	private Set<Role> roles = new HashSet<Role>();

	/*
	 * public User() { roles.add(new Role()); }
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id", unique = true, nullable = false, length = 20)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank(message = "用户名不能为空")
	//@NotBlank(message = "{valid.username}")
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank(message = "密码不能为空")
	//@NotBlank(message = "{valid.password}")
	@Column(name = "password", nullable = false, length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank(message = "状态不能为空")
	//@NotBlank(message = "{valid.state}")
	@Column(name = "state", nullable = false, length = 45)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@ManyToMany(fetch = FetchType.EAGER/* ,cascade={CascadeType.ALL} */)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state + ", roles="
				+ roles + "]";
	}
}
