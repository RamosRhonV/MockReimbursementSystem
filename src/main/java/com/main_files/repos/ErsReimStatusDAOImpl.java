package com.main_files.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.main_files.models.ErsReimStatus;
import com.main_files.utils.HibernateUtil;

public class ErsReimStatusDAOImpl implements ErsReimStatusDAO
{
	public List<ErsReimStatus> findAllReimStatus() 
	{
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsReimStatus").list();
	}

	public ErsReimStatus findById(int id) 
	{
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimStatus.class, id);
	}

	public boolean addStatus(ErsReimStatus ersReimStatus) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersReimStatus);
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

	public boolean updateStatus(ErsReimStatus ersReimStatus) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(ersReimStatus);
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

	public boolean deleteStatus(ErsReimStatus ersReimStatus) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(ersReimStatus);
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
