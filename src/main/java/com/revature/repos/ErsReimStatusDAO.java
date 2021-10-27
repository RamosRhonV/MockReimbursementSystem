package com.revature.repos;

import java.util.List;

import com.revature.models.ErsReimStatus;

public interface ErsReimStatusDAO 
{
	List<ErsReimStatus> findAllReimStatus();
	ErsReimStatus findById(int id);
	
	boolean addStatus(ErsReimStatus ersReimStatus);
	boolean updateStatus(ErsReimStatus ersReimStatus);
	boolean deleteStatus(ErsReimStatus ersReimStatus);
}
