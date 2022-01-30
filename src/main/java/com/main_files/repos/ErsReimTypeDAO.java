package com.main_files.repos;

import java.util.List;

import com.main_files.models.ErsReimType;

public interface ErsReimTypeDAO 
{
	List<ErsReimType> findAllReimType();
	ErsReimType findById(int id);
	
	boolean addType(ErsReimType ersReimType);
	boolean updateType(ErsReimType ersReimType);
	boolean deleteType(ErsReimType ersReimType);
}
