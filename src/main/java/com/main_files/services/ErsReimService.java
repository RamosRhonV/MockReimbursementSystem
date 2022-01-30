package com.main_files.services;

import java.util.List;

import com.main_files.models.ErsReim;
import com.main_files.repos.ErsReimDAO;
import com.main_files.repos.ErsReimDAOImpl;

public class ErsReimService 
{
	private ErsReimDAO ersReimDAO = new ErsReimDAOImpl();
	
	public List<ErsReim> getAllReim()
	{
		return ersReimDAO.findAllReimbursements();
	}
	
	public ErsReim getReimbursement(int id)
	{
		ErsReim ersReim = ersReimDAO.findById(id);
		
		if (ersReim == null)
		{
			return ersReim;
		}
		else
		{
			return new ErsReim();
		}
	}
	
	public boolean addReim(ErsReim ersReim)
	{
		return ersReimDAO.addErsReim(ersReim);
	}
	
	public boolean updateReim(ErsReim ersReim)
	{
		return ersReimDAO.updateErsReim(ersReim);
	}
	
	public boolean deleteReim(ErsReim ersReim)
	{
		return ersReimDAO.deleteErsReim(ersReim);
	}
}
