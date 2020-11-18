package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feed.Feed;
import model.feed.FeedDAO;


public class UpdateLikeAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		String strNum = request.getParameter("feedNo");

		try {
			if (strNum == null || strNum.length() == 0) {
				throw new Exception("feedNO입력값이 충분하지 않습니다.");
			}

			int fno = Integer.parseInt(strNum);
			Feed feed = FeedDAO.updateLike(fno, true);
			if (feed == null) {
				throw new Exception("Feed가 존재하지 않습니다.");
			} else {
				request.setAttribute("list", feed);
				url = "feed.jsp";
			}
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}