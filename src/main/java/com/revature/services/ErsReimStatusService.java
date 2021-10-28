package com.revature.services;

import java.util.List;

import com.revature.models.ErsReimStatus;
import com.revature.repos.ErsReimStatusDAO;
import com.revature.repos.ErsReimStatusDAOImpl;

public class ErsReimStatusService 
{
	private ErsReimStatusDAO ersReimStatusDAO = new ErsReimStatusDAOImpl();
	
	public List<ErsReimStatus> getAllReimStatus()
	{
		return ersReimStatusDAO.findAllReimStatus();
	}
	
	public ErsReimStatus getStatus(int id)
	{
		ErsReimStatus ersReimStatus = ersReimStatusDAO.findById(id);
		
		if(ersReimStatus == null)
		{
			return ersReimStatus;
		}
		else
		{
			return new ErsReimStatus();
		}
	}
	
	public boolean addStatus(ErsReimStatus ersReimStatus)
	{
		return ersReimStatusDAO.addStatus(ersReimStatus);
	}
	
	public boolean updateStatus(ErsReimStatus ersReimStatus)
	{
		return ersReimStatusDAO.updateStatus(ersReimStatus);
	}
	
	public boolean deleteStatus(ErsReimStatus ersReimStatus)
	{
		return ersReimStatusDAO.deleteStatus(ersReimStatus);
	}
}
