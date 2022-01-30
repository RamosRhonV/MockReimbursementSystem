package com.main_files.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErsUserRoles 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int ers_user_role_id;
	private String user_role;
	
	public ErsUserRoles(int userRoleId, String userRole)
	{
		this.ers_user_role_id = userRoleId;
		this.user_role = userRole;
	}
	
	public ErsUserRoles()
	{
		super();
	}
	
	// getter methods
	public int getUserRoleId()
	{
		return ers_user_role_id;
	}
	
	public String getUserRole()
	{
		return user_role;
	}
	
	// setter methods
	public void setUserRoleId(int userRoleId)
	{
		this.ers_user_role_id = userRoleId;
	}
	
	public void setUserRole(String userRole)
	{
		this.user_role = userRole;
	}
}
