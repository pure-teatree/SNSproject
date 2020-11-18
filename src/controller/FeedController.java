package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;


@WebServlet("/feed")
public class FeedController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		if(command == null) {
			command = "list";
		}
		String id = request.getParameter("id");
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		action.execute(request, response);
	}	
}