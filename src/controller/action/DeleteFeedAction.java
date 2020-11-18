package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feed.FeedDAO;

public class DeleteFeedAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum = request.getParameter("fno");
		
		try{
			if(strNum == null || strNum.trim().length() == 0){
				throw new Exception("입력값이 충분하지 않습니다.");
			}
		
			int fno = Integer.parseInt(strNum);
			boolean result = FeedDAO.deleteFeed(fno);
			
			if(result){
				response.sendRedirect("index.html");
				return;
			}else{
				throw new Exception("이미 삭제된 게시물이거나, 비밀번호가 올바르지 않습니다.");
			}
		}catch (SQLException e) {
			request.setAttribute("errorMsg", "시스템 문제가 발생했습니다.");
		}catch (Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
}
