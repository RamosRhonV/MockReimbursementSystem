package com.revature.services;

import java.util.List;

import com.revature.models.ErsReim;
import com.revature.repos.ErsReimDAO;
import com.revature.repos.ErsReimDAOImpl;

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
