package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feed.Feed;
import model.feed.FeedDAO;

public class UpdateFeedAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum = request.getParameter("fno");
		String content = request.getParameter("content");
		
		try{
			if(strNum == null || strNum.trim().length() == 0 ||
					content == null || content.trim().length() == 0) {
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			
			int fno = Integer.parseInt(strNum);
			Feed feed = FeedDAO.getContent(fno);
			
			if (feed == null) {
				throw new Exception("이미 삭제된 피드입니다.");
			}
			
			feed.setContent(content);
			
			boolean result = FeedDAO.updateFeed(feed);
			
			if(result){
				response.sendRedirect("feed?command=view&num=" + fno);
			}else{
				throw new Exception("게시물이 존재하지 않거나, 비밀번호가 올바르지 않습니다.");
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
