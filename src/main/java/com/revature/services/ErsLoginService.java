package com.revature.services;

import com.revature.models.ErsUsers;
import com.revature.models.ErsUsersDTO;
import com.revature.repos.ErsUsersDAOImpl;

public class ErsLoginService 
{
	private ErsUsersDAOImpl ersUsersDAOImpl = new ErsUsersDAOImpl();
	
	public boolean ersLogin(ErsUsersDTO ersUsersDTO)
	{
		ErsUsers ersUser = ersUsersDAOImpl.findById(ersUsersDTO.id); 
		
		if((ersUser != null) && (ersUsersDTO.password.hashCode() == ersUser.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
