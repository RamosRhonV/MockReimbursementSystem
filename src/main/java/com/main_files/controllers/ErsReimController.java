package com.main_files.controllers;

import com.main_files.models.ErsReim;
import com.main_files.services.ErsReimService;

import java.util.List;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsReimController implements Controller
{
	private ErsReimService ersReimService = new ErsReimService();
	
	public Handler getAllReimbursements = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			List<ErsReim> reimList = ersReimService.getAllReim();
			
			ctx.json(reimList);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler getReimbursement = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			String param = ctx.pathParam("ErsReim");
			int paramToInt = Integer.parseInt(param);
			
			ErsReim ersReim = ersReimService.getReimbursement(paramToInt);
			ctx.json(ersReim);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler addReimbursement = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReim ersReim = ctx.bodyAsClass(ErsReim.class);
			
			if(ersReimService.addReim(ersReim))
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
	
	public Handler updateReimbursement = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReim ersReim = ctx.bodyAsClass(ErsReim.class);
			
			if(ersReimService.updateReim(ersReim))
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
	
	public Handler deleteReimbursement = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsReim ersReim = ctx.bodyAsClass(ErsReim.class);
			
			if(ersReimService.deleteReim(ersReim))
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
		app.get("/ersreim", this.getAllReimbursements);
		app.get("/ersreim/:ersreim", this.getReimbursement);
		app.post("/ersreim", this.addReimbursement);
		app.put("/ersreim", this.updateReimbursement);
		app.delete("/ersreim/:ersreim", this.deleteReimbursement);
	}
}
