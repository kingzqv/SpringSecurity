package com.spring.entity;

//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "test")
public class Role {

	private int id;
	private String role;
	private String note;

	/*@ManyToMany(fetch=FetchType.EAGER,mappedBy = "roles"),cascade={CascadeType.ALL})
	@JoinTable(name = "user_role", 
             joinColumns = { @JoinColumn(name = "role_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "user_id") })*/
	/*@ManyToMany(fetch=FetchType.EAGER,mappedBy = "roles")*/
	/*private Set<User> users = new HashSet<User>();*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "role", unique = true, nullable = false, length = 45)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "note", length = 255)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/*public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", note=" + note + "]";
	}
}
