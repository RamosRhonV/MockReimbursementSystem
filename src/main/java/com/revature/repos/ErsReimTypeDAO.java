package com.revature.repos;

import java.util.List;

import com.revature.models.ErsReimType;

public interface ErsReimTypeDAO 
{
	List<ErsReimType> findAllReimType();
	ErsReimType findById(int id);
	
	boolean addType(ErsReimType ersReimType);
	boolean updateType(ErsReimType ersReimType);
	boolean deleteType(ErsReimType ersReimType);
}
