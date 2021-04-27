package co.jelly.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;

public class MemberSigninForm implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//회원 가입 페이지
		return "member/memberSigninForm.tiles";
	}

}
