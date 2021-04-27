package co.jelly.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;
import co.jelly.dbtest.member.service.MemberService;
import co.jelly.dbtest.member.serviceImpl.MemberServiceImpl;

public class MemberIdCheck implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복 체크
		
		MemberServiceImpl member = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean check = member.idCheck(id);
		//true면 존재, false면 사용가능
		String msg ; 
		if(!check) 
			msg = "사용가능한 아이디입니다.";
		else
			msg = "이미 존재하는 아이디입니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		return "member/memberIdCheck.tiles";
	}

}
