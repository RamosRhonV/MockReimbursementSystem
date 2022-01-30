package com.revature.repos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsUserRoles;
import com.revature.utils.HibernateUtil;

public class ErsUserRolesDAOImpl implements ErsUserRolesDAO
{

	public List<ErsUserRoles> findAllUserRoles() 
	{
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsUserRoles").list();
	}

	public ErsUserRoles findById(int id) 
	{
		Session session = HibernateUtil.getSession();
		return session.get(ErsUserRoles.class, id);
	}

	public boolean addRole(ErsUserRoles ersUserRole) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersUserRole);
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

	public boolean updateRole(ErsUserRoles ersUserRole) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(ersUserRole);
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

	public boolean deleteRole(ErsUserRoles ersUserRole) 
	{
		try 
		{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.delete(ersUserRole);
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
