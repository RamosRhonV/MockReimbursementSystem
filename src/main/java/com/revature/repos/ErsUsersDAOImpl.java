package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

public class ErsUsersDAOImpl implements ErsUsersDAO
{
	public List<ErsUsers> findAllUsers() 
	{
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsUsers").list();
	}

	public ErsUsers findById(int id) 
	{
		Session session = HibernateUtil.getSession();
		return session.get(ErsUsers.class, id);
	}

	public boolean addErsUser(ErsUsers ersUser) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersUser);
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

	public boolean updateErsUser(ErsUsers ersUser) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(ersUser);
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

	public boolean deleteErsUser(ErsUsers ersUser) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(ersUser);
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
