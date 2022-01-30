package com.revature.repos;

import java.util.List;

import com.revature.models.ErsReim;

public interface ErsReimDAO 
{
	List<ErsReim> findAllReimbursements();
	ErsReim findById(int id);
	
	boolean addErsReim(ErsReim ersReim);
	boolean updateErsReim(ErsReim ersReim);
	boolean deleteErsReim(ErsReim ersReim);
}
