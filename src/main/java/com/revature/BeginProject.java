package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.ErsReimController;
import com.revature.controllers.ErsReimStatusController;
import com.revature.controllers.ErsReimTypeController;
import com.revature.controllers.ErsUserController;
import com.revature.controllers.ErsUserRolesController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class BeginProject 
{
	private static Javalin app;
	
	public static void main(String[] args)
	{
		app = Javalin.create((config) -> 
			{
				config.addStaticFiles("/static", Location.CLASSPATH);
			}
		);
		
		configure(new ErsUserController(), new ErsReimController(), new ErsReimTypeController(), new ErsReimStatusController(), new ErsUserRolesController());
		
		app.start(8081);
	}
	
	private static void configure(Controller... controllers)
	{
		for (Controller c:controllers)
		{
			c.addRoutes(app);
		}
	}
}
