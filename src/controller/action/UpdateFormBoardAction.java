package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feed.Feed;
import model.feed.FeedDAO;

public class UpdateFormBoardAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String strNum=request.getParameter("num");
		
		try{
			if(strNum == null || strNum.trim().length() == 0){
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			Feed gContent = FeedDAO.getContent(Integer.parseInt(strNum));
			if(gContent == null){
				throw new Exception("게시물이 존재하지 않습니다.");
			}else{
				gContent.setContent(gContent.getContent().replaceAll("<br/>", "\n"));
				request.setAttribute("resultContent", gContent);
				url = "update.jsp";
			}
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
