package com.main_files.services;

import com.main_files.models.ErsUsers;
import com.main_files.models.ErsUsersDTO;
import com.main_files.repos.ErsUsersDAOImpl;

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
