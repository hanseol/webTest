package co.jelly.dbtest.notice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class NoticeList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 전체보기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		list = dao.noticeSelectList();
		request.setAttribute("notices", list);
		
		return "notice/noticeList.tiles";
	}

}
