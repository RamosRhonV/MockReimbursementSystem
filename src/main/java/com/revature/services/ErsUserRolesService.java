package com.revature.services;

import java.util.List;

import com.revature.models.ErsUserRoles;
import com.revature.repos.ErsUserRolesDAO;
import com.revature.repos.ErsUserRolesDAOImpl;

public class ErsUserRolesService 
{
	private ErsUserRolesDAO ersUserRolesDAO = new ErsUserRolesDAOImpl();
	
	public List<ErsUserRoles> getAllUsers()
	{
		return ersUserRolesDAO.findAllUserRoles();
	}
	
	public ErsUserRoles getUserRole(int id)
	{
		ErsUserRoles ersUserRole = ersUserRolesDAO.findById(id);
		
		if(ersUserRole == null)
		{
			return ersUserRole;
		}
		else
		{
			return new ErsUserRoles();
		}
	}
	
	public boolean addErsUser(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.addRole(ersUserRole);
	}
	
	public boolean updateErsUser(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.updateRole(ersUserRole);
	}
	
	public boolean deleteErsUser(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.deleteRole(ersUserRole);
	}
}
