package co.jelly.dbtest.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class NoticeContent implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//세부 내역 보기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo = dao.noticeSelect(vo);
		request.setAttribute("vo", vo);
		
		return "notice/noticeContent.tiles";
	}

}
