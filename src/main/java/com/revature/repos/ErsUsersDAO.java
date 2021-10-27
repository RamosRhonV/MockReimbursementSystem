package com.revature.repos;

import java.util.List;

import com.revature.models.ErsUsers;

public interface ErsUsersDAO 
{
	List<ErsUsers> findAllUsers();
	ErsUsers findById(int id);
	
	boolean addErsUser(ErsUsers ersUser);
	boolean updateErsUser(ErsUsers ersUser);
	boolean deleteErsUser(ErsUsers ersUser);
}
