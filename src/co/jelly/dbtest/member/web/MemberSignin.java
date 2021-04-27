package co.jelly.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.member.service.MemberService;
import co.jelly.dbtest.member.serviceImpl.MemberServiceImpl;
import co.jelly.dbtest.member.vo.MemberVO;

public class MemberSignin implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//sign in
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		
		int n = dao.insertMember(vo);
		
		String viewPage;
		if(n!=0) {
			viewPage ="member/memberSigninSuccess.tiles";
		}else {
			viewPage = "member/memberSigninFail.tiles";
		}
		
		return viewPage;
	}

}
