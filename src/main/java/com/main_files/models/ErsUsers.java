package com.main_files.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ErsUsers class models the ers_users table
 * 
 * @author Rhon Vincent Ramos
 *
 */

@Entity
public class ErsUsers 
{ 
	@Id
	private int ers_users_id;
	private String ers_username;
	private int ers_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private int user_role_id;
	
	public ErsUsers(int id, String name, int password, String firstName, String lastName, String email, int roleId)
	{
		this.ers_users_id = id;
		this.ers_username = name;
		this.ers_password = password;
		this.user_first_name = firstName;
		this.user_last_name = lastName;
		this.user_email = email;
		this.user_role_id = roleId;
	}

	public ErsUsers(String name, int password, String firstName, String lastName, String email, int roleId)
	{
		this.ers_username = name;
		this.ers_password = password;
		this.user_first_name = firstName;
		this.user_last_name = lastName;
		this.user_email = email;
		this.user_role_id = roleId;
	}
	
	public ErsUsers() 
	{
		super();
	}

	// getter methods
	public int getId()
	{
		return ers_users_id;
	}
	
	public String getUsername()
	{
		return ers_username;
	}
	
	public int getPassword()
	{
		return ers_password;
	}
	
	public String getFirstName()
	{
		return user_first_name;
	}
	
	public String getLastName()
	{
		return user_last_name;
	}
	
	public String getEmail()
	{
		return user_email;
	}
	
	public int getRoleId()
	{
		return user_role_id;
	}
	
	// setter methods
	public void setId(int id)
	{
		this.ers_users_id = id;
	}
	
	public void setUsername(String username)
	{
		this.ers_username = username;
	}
	
	public void setPassword(int password)
	{
		this.ers_password = password;
	}
	
	public void setFirstName(String firstName)
	{
		this.user_first_name = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.user_last_name = lastName;
	}

	public String setEmail(String email)
	{
		return user_email = email;
	}
	
	public int setRoleId(int roleId)
	{
		return user_role_id = roleId;
	}
}
