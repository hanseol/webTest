package co.jelly.dbtest.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.member.web.MemberLogin;
import co.jelly.dbtest.member.web.MemberLoginForm;
import co.jelly.dbtest.member.web.MemberLogout;
import co.jelly.dbtest.member.web.MemberSignin;
import co.jelly.dbtest.member.web.MemberSigninForm;
import co.jelly.dbtest.notice.ajaxweb.AjaxNoticeList;
import co.jelly.dbtest.notice.ajaxweb.AjaxNoticeRegister;
import co.jelly.dbtest.notice.ajaxweb.NoticeClient;
import co.jelly.dbtest.notice.web.MemberInfo;
import co.jelly.dbtest.notice.web.NoticeContent;
import co.jelly.dbtest.notice.web.NoticeList;
import co.jelly.dbtest.notice.web.NoticeRegister;
import co.jelly.dbtest.notice.web.NoticeRegisterForm;
import memberWitdrawal.MemberWithdraw;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet(".do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, DBCommand> map = new HashMap<String, DBCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainPage()); // 시작 페이지
		map.put("/noticeList.do", new NoticeList()); // 공지사항 목록
		map.put("/noticeContent.do", new NoticeContent()); // 공지사항 내용
		map.put("/noticeRegisterForm.do", new NoticeRegisterForm()); // 공지사항 등록페이지
		map.put("/noticeRegister.do", new NoticeRegister()); // 공지사항 저장
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogout.do", new MemberLogout());
		map.put("/memberInfo.do", new MemberInfo());
		map.put("/memberSigninForm.do", new MemberSigninForm());
		map.put("/memberSignin.do", new MemberSignin());
//		map.put("/memberIdCheck.do", new MemberIdCheck());
		map.put("/memberWithdraw.do", new MemberWithdraw());
		map.put("/memberWithdrawForm.do", null);

		// ajax
		map.put("/noticeClient.do", new NoticeClient()); //공지사항 관리자
		map.put("/ajax/noticeList.do", new AjaxNoticeList()); //ajax 공지사항 리스트
		map.put("/ajax/noticeRegister.do", new AjaxNoticeRegister());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DBCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) { // ajax는 forward가 아니기 때문에.
			//ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			
			//뷰페이지 포워드
			if (viewPage.endsWith(".jsp")) {
				viewPage = "WEB-INF/views/" + viewPage;
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}
