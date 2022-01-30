package com.main_files.repos;

import java.util.List;

import com.main_files.models.ErsUsers;

public interface ErsUsersDAO 
{
	List<ErsUsers> findAllUsers();
	ErsUsers findById(int id);
	
	boolean addErsUser(ErsUsers ersUser);
	boolean updateErsUser(ErsUsers ersUser);
	boolean deleteErsUser(ErsUsers ersUser);
}
