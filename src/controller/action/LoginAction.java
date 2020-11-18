package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.Member;
import model.member.MemberDAO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String url = "error.jsp";
	    
	    try {
			Member member = MemberDAO.getMember(id);
			System.out.println("loginaction:"+member.getId()+member.getName());
			if(member == null){
				throw new Exception("입력하신 아이디가 존재하지 않습니다.");
			} else if(!password.equals(member.getPassword())){
				throw new Exception("입력하신 비밀번호가 틀렸습니다.");
			} else {
				HttpSession session = request.getSession();//생성.
			    session.setAttribute("user", member);
			    url = "index.html";
			}
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	}

}