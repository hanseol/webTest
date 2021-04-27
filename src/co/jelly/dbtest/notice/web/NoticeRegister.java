package co.jelly.dbtest.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class NoticeRegister implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeServiceImpl dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		dao.insertNotice(vo);
		
		System.out.println(vo.getId());
		return "noticeList.do";
	}

}
