package com.main_files.repos;

import java.util.List;

import com.main_files.models.ErsReimStatus;

public interface ErsReimStatusDAO 
{
	List<ErsReimStatus> findAllReimStatus();
	ErsReimStatus findById(int id);
	
	boolean addStatus(ErsReimStatus ersReimStatus);
	boolean updateStatus(ErsReimStatus ersReimStatus);
	boolean deleteStatus(ErsReimStatus ersReimStatus);
}
