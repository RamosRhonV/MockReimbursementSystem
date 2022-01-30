package com.main_files.controllers;

import java.util.List;

import com.main_files.models.ErsUsers;
import com.main_files.services.ErsUsersService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsUserController implements Controller
{
    private ErsUsersService ersUsersService = new ErsUsersService();

    public Handler getAllUsers = (ctx) ->
    {
        if(ctx.req.getSession(false) != null)
        {
            List<ErsUsers> userList = ersUsersService.getAllUsers();

            ctx.json(userList);
            ctx.status(200);
        }
        else
        {
            ctx.status(401);
        }
    };

    public Handler getUser = (ctx) ->
    {
        if(ctx.req.getSession(false) != null)
        {
            String param = ctx.pathParam("ErsUsers");
            int paramToInt = Integer.parseInt(param);

            ErsUsers ersUsers = ersUsersService.getUser(paramToInt);
            ctx.json(ersUsers);
            ctx.status(200);
        }
        else
        {
            ctx.status(401);
        }
    };

	public Handler addUser = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUsers ersUsers = ctx.bodyAsClass(ErsUsers.class);
			
			if(ersUsersService.addErsUser(ersUsers))
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
	
	public Handler updateUser = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUsers ersUsers = ctx.bodyAsClass(ErsUsers.class);
			
			if(ersUsersService.updateErsUser(ersUsers))
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
	
	public Handler deleteUser = (ctx) ->
	{
		if(ctx.req.getSession(false) != null)
		{
			ErsUsers ersUsers = ctx.bodyAsClass(ErsUsers.class);
			
			if(ersUsersService.deleteErsUser(ersUsers))
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
		app.get("/ersusers", this.getAllUsers);
		app.get("/ersusers/:ersusers", this.getUser);
		app.post("/ersusers", this.addUser);
		app.put("/ersusers", this.updateUser);
		app.delete("/ersusers/:ersusers", this.deleteUser);
	}
}
