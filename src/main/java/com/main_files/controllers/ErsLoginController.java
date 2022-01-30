package com.revature.controllers;

import com.revature.models.ErsUsersDTO;
import com.revature.services.ErsLoginService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ErsLoginController implements Controller
{
	private ErsLoginService ersLoginService = new ErsLoginService();
	
	private Handler ersLogin = (ctx) ->
	{
		ErsUsersDTO ersUsersDTO = ctx.bodyAsClass(ErsUsersDTO.class);
		
		if (ersLoginService.ersLogin(ersUsersDTO))
		{
			ctx.req.getSession();
			ctx.status(200);
		}
		else
		{
			ctx.req.getSession().invalidate();
			ctx.status(401);
		}
	};
	
	public void addRoutes(Javalin app)
	{
		app.post("/login", this.ersLogin);
	}
}
