package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErsReimStatus 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reimb_status_id;
	private String reimb_status;
	
	public ErsReimStatus(int statusId, String status)
	{
		this.reimb_status_id = statusId;
		this.reimb_status = status;
	}
	
	public ErsReimStatus()
	{
		
	}
	
	// getter methods
	public int getStatusId()
	{
		return reimb_status_id;
	}
	
	public String getStatus()
	{
		return reimb_status;
	}
	
	// setter methods
	public void setStatusId(int statusId)
	{
		this.reimb_status_id = statusId;
	}
	
	public void setStatus(String status)
	{
		this.reimb_status = status;
	}
}
