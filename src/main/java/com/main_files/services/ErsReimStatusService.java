package com.main_files.services;

import java.util.List;

import com.main_files.models.ErsReimStatus;
import com.main_files.repos.ErsReimStatusDAO;
import com.main_files.repos.ErsReimStatusDAOImpl;

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
