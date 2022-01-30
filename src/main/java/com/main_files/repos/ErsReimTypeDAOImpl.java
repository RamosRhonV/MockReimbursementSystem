package com.main_files.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.main_files.models.ErsReimType;
import com.main_files.utils.HibernateUtil;

public class ErsReimTypeDAOImpl implements ErsReimTypeDAO
{
	public List<ErsReimType> findAllReimType() 
	{
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsReimType").list();
	}

	public ErsReimType findById(int id) 
	{
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimType.class, id);
	}

	public boolean addType(ErsReimType ersReimType) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersReimType);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateType(ErsReimType ersReimType) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(ersReimType);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteType(ErsReimType ersReimType) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(ersReimType);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
