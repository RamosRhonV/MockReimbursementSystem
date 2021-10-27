package com.revature.repos;

import java.util.List;

import com.revature.models.ErsUserRoles;

public interface ErsUserRolesDAO 
{
	List<ErsUserRoles> findAllUserRoles();
	ErsUserRoles findById(int id);
	
	boolean addRole(ErsUserRoles ersUserRole);
	boolean updateRole(ErsUserRoles ersUserRole);
	boolean deleteRole(ErsUserRoles ersUserRole);
}
