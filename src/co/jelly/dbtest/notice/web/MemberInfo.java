package co.jelly.dbtest.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jelly.dbtest.common.DBCommand;

public class MemberInfo implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//회원 정보 출력.
		return "member/memberInfo.tiles";
	}

}
