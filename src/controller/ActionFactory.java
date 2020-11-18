package controller;

import controller.action.Action;
import controller.action.AllViewFeedAction;
import controller.action.DeleteFeedAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.UpdateFeedAction;
import controller.action.UpdateFormBoardAction;
import controller.action.UpdateLikeAction;
import controller.action.WriteFeedAction;
import controller.action.SignUpAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;

		if (command.equals("list")) {
			action = new AllViewFeedAction();
			System.out.println("ActionFactory-list요청중");
		} else if (command.equals("write")) {
			action = new WriteFeedAction();
		} else if (command.equals("updateForm")) {
			action = new UpdateFormBoardAction();
		} else if (command.equals("update")) {
			action = new UpdateFeedAction();
		} else if (command.equals("delete")) {
			action = new DeleteFeedAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("signup")) {
			System.out.println("ActionFactory-signup요청중");
			action = new SignUpAction();
		}else if (command.equals("updateLike")) {
			action = new UpdateLikeAction();
		}
		return action;
	}
}