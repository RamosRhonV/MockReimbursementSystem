package com.main_files.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.main_files.models.ErsReim;
import com.main_files.utils.HibernateUtil;

public class ErsReimDAOImpl implements ErsReimDAO
{
	public List<ErsReim> findAllReimbursements() 
	{
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsReim").list();
	}

	public ErsReim findById(int id) 
	{
		Session session = HibernateUtil.getSession();
		return session.get(ErsReim.class, id);
	}

	public boolean addErsReim(ErsReim ersReim) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersReim);
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

	public boolean updateErsReim(ErsReim ersReim) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(ersReim);
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

	public boolean deleteErsReim(ErsReim ersReim) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(ersReim);
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
