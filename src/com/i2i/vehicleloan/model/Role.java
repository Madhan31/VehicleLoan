package com.i2i.vehicleloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role pojo class which has setter and getter methods for accessing role details.
 * 
 * @author Madhan
 *
 */
@Entity
@Table(name = "role")
public class Role {
	
	/**
	 * Constructor without argument is used to create a role object. 
	 */
	public Role() { 
	}
	
	/**
	 * Constructor with argument is used to create a role role object.
	 * 
	 * @param roleId
	 *     Contains unique id for an role.    
	 * @param roleName
	 *     Contains name of role of user.
	 */
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	@Id
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role_name")
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/* 
	 * Return object to string fornat.
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
