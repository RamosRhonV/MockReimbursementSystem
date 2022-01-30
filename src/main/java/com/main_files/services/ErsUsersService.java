package com.main_files.services;

import java.util.List;

import com.main_files.models.ErsUsers;
import com.main_files.repos.ErsUsersDAO;
import com.main_files.repos.ErsUsersDAOImpl;

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
