package com.revature.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ErsReimType 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reimb_type_id;
	private String reimb_type;

	public ErsReimType(int typeId, String type)
	{
		this.reimb_type_id = typeId;
		this.reimb_type = type;
	}
	
	public ErsReimType()
	{
		super();
	}
	
	// getter methods
	public int getTypeId()
	{
		return reimb_type_id;
	}

	public String getType()
	{
		return reimb_type;
	}
	
	// setter methods
	public void setTypeId(int typeId)
	{
		this.reimb_type_id = typeId;
	}
	
	public void setType(String type)
	{
		this.reimb_type = type;
	}

}
