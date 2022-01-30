package com.revature.services;

import java.util.List;

import com.revature.models.ErsReimType;
import com.revature.repos.ErsReimTypeDAO;
import com.revature.repos.ErsReimTypeDAOImpl;

public class ErsReimTypeService 
{
	private ErsReimTypeDAO ersReimTypeDAO = new ErsReimTypeDAOImpl();
	
	public List<ErsReimType> getAllReimType()
	{
		return ersReimTypeDAO.findAllReimType();
	}
	
	public ErsReimType getType(int id)
	{
		ErsReimType ersReimType = ersReimTypeDAO.findById(id);
		
		if(ersReimType == null)
		{
			return ersReimType;
		}
		else
		{
			return new ErsReimType();
		}
	}
	
	public boolean addType(ErsReimType ersReimType)
	{
		return ersReimTypeDAO.addType(ersReimType);
	}
	
	public boolean updateType(ErsReimType ersReimType)
	{
		return ersReimTypeDAO.updateType(ersReimType);
	}
	
	public boolean deleteType(ErsReimType ersReimType)
	{
		return ersReimTypeDAO.deleteType(ersReimType);
	}
}
