package com.main_files.controllers;

import java.util.List;

import com.main_files.models.ErsReimStatus;
import com.main_files.services.ErsReimStatusService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsReimStatusController implements Controller
{
	private ErsReimStatusService ersReimStatusService = new ErsReimStatusService();
	
	public Handler getAllStatus = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			List<ErsReimStatus> statusList = ersReimStatusService.getAllReimStatus();
			
			ctx.json(statusList);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler getStatus = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			String param = ctx.pathParam("ErsReimStatus");
			int paramToInt = Integer.parseInt(param);
			
			ErsReimStatus ersReimStatus = ersReimStatusService.getStatus(paramToInt);
			ctx.json(ersReimStatus);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler addStatus = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimStatus ersReimStatus = ctx.bodyAsClass(ErsReimStatus.class);
			
			if(ersReimStatusService.addStatus(ersReimStatus))
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
	
	public Handler updateStatus = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimStatus ersReimStatus = ctx.bodyAsClass(ErsReimStatus.class);
			
			if(ersReimStatusService.updateStatus(ersReimStatus))
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
	
	public Handler deleteStatus = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReimStatus ersReimStatus = ctx.bodyAsClass(ErsReimStatus.class);
			
			if(ersReimStatusService.deleteStatus(ersReimStatus))
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
		app.get("/ersreimstatus", this.getAllStatus);
		app.get("/ersreimstatus/:ersreimstatus", this.getStatus);
		app.post("/ersreimstatus", this.addStatus);
		app.put("/ersreimstatus", this.updateStatus);
		app.delete("/ersreimstatus/:ersreimstatus", this.deleteStatus);
	}
}
