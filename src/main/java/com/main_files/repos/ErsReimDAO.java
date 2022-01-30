package com.main_files.repos;

import java.util.List;

import com.main_files.models.ErsReim;

public interface ErsReimDAO 
{
	List<ErsReim> findAllReimbursements();
	ErsReim findById(int id);
	
	boolean addErsReim(ErsReim ersReim);
	boolean updateErsReim(ErsReim ersReim);
	boolean deleteErsReim(ErsReim ersReim);
}
