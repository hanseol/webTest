package co.jelly.dbtest.notice.ajaxweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.jelly.dbtest.notice.vo.NoticeVO;

public class AjaxNoticeList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = dao.noticeSelectList();
	
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return "ajax:"+str;
	}

}
