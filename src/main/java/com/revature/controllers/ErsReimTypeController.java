package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsReim;
import com.revature.models.ErsReimType;
import com.revature.services.ErsReimTypeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsReimTypeController implements Controller
{
	private ErsReimTypeService ersReimTypeService = new ErsReimTypeService();
	
	public Handler getAllTypes = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			List<ErsReimType> typeList = ersReimTypeService.getAllReimType();
			
			ctx.json(typeList);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler getType = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			String param = ctx.pathParam("ErsReimType");
			int paramToInt = Integer.parseInt(param);
			
			ErsReimType ersReimType = ersReimTypeService.getType(paramToInt);
			ctx.json(ersReimType);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler addType = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimType ersReimType = ctx.bodyAsClass(ErsReimType.class);
			
			if(ersReimTypeService.addType(ersReimType))
			{
				ctx.status(200);
			}
			else
			{
				ctx.status(400);
			}
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler updateType = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimType ersReimType = ctx.bodyAsClass(ErsReimType.class);
			
			if(ersReimTypeService.updateType(ersReimType))
			{
				ctx.status(200);
			}
			else
			{
				ctx.status(400);
			}
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler deleteType = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimType ersReimType = ctx.bodyAsClass(ErsReimType.class);
			
			if(ersReimTypeService.deleteType(ersReimType))
			{
				ctx.status(200);
			}
			else
			{
				ctx.status(400);
			}
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public void addRoutes(Javalin app) 
	{
		app.get("/ersreimtype", this.getAllTypes);
		app.get("/ersreimtype/:ersreimtype", this.getType);
		app.post("/ersreimtype", this.addType);
		app.put("/ersreimtype", this.updateType);
		app.delete("/ersreimtype/:ersreimtype", this.deleteType);
	}
}
