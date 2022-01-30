package com.revature;

import java.sql.Timestamp;

import com.revature.controllers.Controller;
import com.revature.controllers.ErsReimController;
import com.revature.controllers.ErsReimStatusController;
import com.revature.controllers.ErsReimTypeController;
import com.revature.controllers.ErsUserController;
import com.revature.controllers.ErsLoginController;
import com.revature.controllers.ErsUserRolesController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import com.revature.models.ErsUsers;
import com.revature.repos.ErsUserRolesDAOImpl;
import com.revature.repos.ErsUsersDAOImpl;
import com.revature.services.ErsUserRolesService;
import com.revature.services.ErsUsersService;
import com.revature.models.ErsUserRoles;

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
		
		configure(new ErsLoginController(), new ErsUserController(), new ErsReimController(), new ErsReimTypeController(), new ErsReimStatusController(), new ErsUserRolesController());
		
		app.start(8081);
		populateTables();

	}
	
	private static void configure(Controller... controllers)
	{
		for (Controller c:controllers)
		{
			c.addRoutes(app);
		}
	}

	/*
	 * populates tables with pre-defined values for example purposes
	 */
	public static void populateTables()
	{
		ErsUsersDAOImpl usersDAOImpl = new ErsUsersDAOImpl();

		ErsUsersService userService = new ErsUsersService();
		ErsUserRolesService roleService = new ErsUserRolesService();

		if ((usersDAOImpl.findById(1)) == null || (usersDAOImpl.findById(1) == null))
		{
			String bingusPass = "321";
			String floppaPass = "456";

			ErsUsers ersUserBingus = new ErsUsers(123, "bingusPloyee", bingusPass.hashCode(), "bingus", "the sphinx", "bingussphinx@revingus.net", 1);
			ErsUsers ersUserFloppa = new ErsUsers(321, "floppaManager", floppaPass.hashCode(), "floppa", "the caracal", "floppacaracal@revingus.net", 2);
			ErsUserRoles employeeRole = new ErsUserRoles(1, "employee");
			ErsUserRoles managerRole = new ErsUserRoles(2, "manager");

			userService.addErsUser(ersUserBingus);
			userService.addErsUser(ersUserFloppa);
			roleService.addRole(employeeRole);
			roleService.addRole(managerRole);
		}
	}
}
