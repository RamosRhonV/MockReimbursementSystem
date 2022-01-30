package com.main_files.controllers;

import java.util.List;

import com.main_files.models.ErsUserRoles;
import com.main_files.services.ErsUserRolesService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsUserRolesController implements Controller
{
	private ErsUserRolesService ersUserRolesService = new ErsUserRolesService();
	
	public Handler getAllRoles = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			List<ErsUserRoles> rolesList = ersUserRolesService.getAllUsers();

			ctx.json(rolesList);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler getRole = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			String param = ctx.pathParam("ErsReimRole");
			int paramToInt = Integer.parseInt(param);
			
			ErsUserRoles ersUserRole = ersUserRolesService.getUserRole(paramToInt);
			ctx.json(ersUserRole);
			ctx.status(200);
		}
		else
		{
			ctx.status(401);
		}
	};
	
	public Handler addRole = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUserRoles ersUserRole = ctx.bodyAsClass(ErsUserRoles.class);
			
			if(ersUserRolesService.addRole(ersUserRole))
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
	
	public Handler updateRole = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUserRoles ersUserRole = ctx.bodyAsClass(ErsUserRoles.class);
			
			if(ersUserRolesService.updateRole(ersUserRole))
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
	
	public Handler deleteRole = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUserRoles ersUserRole = ctx.bodyAsClass(ErsUserRoles.class);
			
			if(ersUserRolesService.deleteRole(ersUserRole))
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
		app.get("/ersuserrole", this.getAllRoles);
		app.get("/ersuserrole/:ersuserrole", this.getRole);
		app.post("/ersuserrole", this.addRole);
		app.put("/ersuserrole", this.updateRole);
		app.delete("/ersuserroles/:ersuserrole", this.deleteRole);
	}
}
