package co.jelly.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;

public class MemberLoginForm implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberLoginForm.tiles";
	}

}
