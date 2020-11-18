package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //세션 삭제
		request.getSession().invalidate(); //세션 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;

		response.sendRedirect("log_in.html");
	}

}
