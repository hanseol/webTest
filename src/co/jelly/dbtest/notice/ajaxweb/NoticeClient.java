package co.jelly.dbtest.notice.ajaxweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;

public class NoticeClient implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "notice/noticeClient.tiles";
	}

}
