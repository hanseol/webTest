<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	function formCheck() {
		if (frm.memberId.value == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}
		if (frm.memberPassword.value == "") {
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}

		frm.submit();
	}
</script>

	
	<div class="form" align="center">
		<form id="frm" name="frm" action="memberLogin.do" method="post"
			class="loginForm">
			<h3>Login</h3>
			<div class="idForm">
				<input type="text" class="memberId" name="memberId" placeholder="ID">
			</div>
			<div class="passForm">
				<input type="password" class="memberPassword" name="memberPassword"
					placeholder="PASSWORD">
			</div>
			<input type="button" onclick="formCheck()" value="Login" class="btn">
			<input type="button" value="Go home" class="btn"
				onclick="location.href='main.do'">
			<div class="bottomText">
				Don't you have ID? <a href="#">sign up</a>
			</div>
		</form>
	</div>
