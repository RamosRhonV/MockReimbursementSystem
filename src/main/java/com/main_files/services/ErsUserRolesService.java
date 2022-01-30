package com.main_files.services;

import java.util.List;

import com.main_files.models.ErsUserRoles;
import com.main_files.repos.ErsUserRolesDAO;
import com.main_files.repos.ErsUserRolesDAOImpl;

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
	
	public boolean addRole(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.addRole(ersUserRole);
	}
	
	public boolean updateRole(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.updateRole(ersUserRole);
	}
	
	public boolean deleteRole(ErsUserRoles ersUserRole)
	{
		return ersUserRolesDAO.deleteRole(ersUserRole);
	}
}
