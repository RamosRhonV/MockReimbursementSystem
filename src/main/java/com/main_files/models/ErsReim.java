package com.revature.models;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErsReim 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reimb_id;
	private int reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private Blob reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;
	
	public ErsReim (int id, int amount, Timestamp submitted, Timestamp resolved, 
					String description, Blob receipt, int author, int resolver, int statusId, int typeId)
	{
		this.reimb_id = id;
		this.reimb_amount = amount;
		this.reimb_submitted = submitted;
		this.reimb_resolved = resolved;
		this.reimb_description = description;
		this.reimb_receipt = receipt;
		this.reimb_author = author;
		this.reimb_resolver = resolver;
		this.reimb_status_id = statusId;
		this.reimb_type_id = typeId;
	}
	
	public ErsReim()
	{
		super();
	}
	
	// getter methods
	public int getId()
	{
		return reimb_id;
	}
	
	public int getAmount()
	{
		return reimb_amount;
	}
	
	public Timestamp getSubmitted()
	{
		return reimb_submitted;
	}
	
	public Timestamp getResolved()
	{
		return reimb_resolved;
	}
	
	public String getDescription()
	{
		return reimb_description;
	}
	
	public Blob getReceipt()
	{
		return reimb_receipt;
	}
	
	public int getAuthor()
	{
		return reimb_author;
	}
	
	public int getResolver()
	{
		return reimb_resolver;
	}
	
	public int getStatusId()
	{
		return reimb_status_id;
	}
	
	public int getTypeId()
	{
		return reimb_type_id;
	}
	
	// setter methods
	public void setId(int id)
	{
		this.reimb_id = id;
	}
	
	public void setAmount(int amount)
	{
		this.reimb_amount = amount;
	}
	
	public void setSubmitted(Timestamp submitted)
	{
		this.reimb_submitted = submitted;
	}
	
	public void setResolved(Timestamp resolved)
	{
		this.reimb_resolved = resolved;
	}
	
	public void setDescription(String description)
	{
		this.reimb_description = description;
	}
	
	public void setReceipt(Blob receipt)
	{
		this.reimb_receipt = receipt;
	}
	
	public void setAuthor(int author)
	{
		this.reimb_author = author;
	}
	
	public void setResolver(int resolver)
	{
		this.reimb_resolver = resolver;
	}
	
	public void setStatusId(int statusId)
	{
		this.reimb_status_id = statusId;
	}
	
	public void setTypeId(int typeId)
	{
		this.reimb_type_id = typeId;
	}
}
