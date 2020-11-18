package controller.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feed.Feed;
import model.member.Member;
import model.member.MemberDAO;



public class SignUpAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String info = request.getParameter("introduce");
		
		try{
			
			boolean result = MemberDAO.joinMember(Member.builder().id(id)
					.password(password).name(name).info(info).feeds(new ArrayList<Feed>()).build());
		
			if(result){
				response.sendRedirect("index.html"); 
			}else{
				throw new Exception("입력값이 충분하지 않습니다.");
			}
		}catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
	}

}
