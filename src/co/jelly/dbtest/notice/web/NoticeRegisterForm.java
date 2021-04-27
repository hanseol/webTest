package co.jelly.dbtest.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class NoticeRegisterForm implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//공지 등록 페이지.
		
		return "notice/noticeRegisterForm.tiles";
	}

}
