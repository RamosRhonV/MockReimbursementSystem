package com.revature.services;

import java.util.List;

import com.revature.models.ErsUsers;
import com.revature.repos.ErsUsersDAO;
import com.revature.repos.ErsUsersDAOImpl;

public class ErsUsersService 
{
	private ErsUsersDAO ersUsersDAO = new ErsUsersDAOImpl();
	
	public List<ErsUsers> getAllUsers()
	{
		return ersUsersDAO.findAllUsers();
	}
	
	public ErsUsers getUser(int id)
	{
		ErsUsers ersUser = ersUsersDAO.findById(id);
		
		if(ersUser == null)
		{
			return ersUser;
		}
		else
		{
			return new ErsUsers();
		}
	}
	
	public boolean addErsUser(ErsUsers ersUser)
	{
		return ersUsersDAO.addErsUser(ersUser);
	}
	
	public boolean updateErsUser(ErsUsers ersUser)
	{
		return ersUsersDAO.updateErsUser(ersUser);
	}
	
	public boolean deleteErsUser(ErsUsers ersUser)
	{
		return ersUsersDAO.deleteErsUser(ersUser);
	}
}
