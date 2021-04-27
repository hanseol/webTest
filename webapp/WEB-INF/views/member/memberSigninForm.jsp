<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
$(document).ready(function (){
	$("#idCheck").click(function(){
		event.preventDefault();
		var userid=$("#memberId").val();
		console.log(userid);
			$.ajax({
				type : 'POST',
				data: {id:userid},
				url : "ajaxMemberIdCheck", //별도 서블릿으로 만들었음. .do 에서 제외.(컨트롤러 안탐.)
				success : function(data){
					if(data>0){
						alert("아이디가 존재합니다.");
						$("memberId").val("");
						$("#memberId").focus();
					}else{
						alert("사용가능한 아이디입니다.");
						$("idCheck").val("checked");
						$("#memberPassword").focus();
						
					}
				},
				error: function(error){
					alert("error:" + error);
				}
			});
		});
	});
</script>
<script type="text/javascript">
	
	function formCheck() {
		event.preventDefault();
		
		if (frm.memberId.value == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}
		if (frm.idCheck.value=="unChecked"){
			alert("아이디 중복확인을 하세요.");
			return false;
		}
		if (frm.memberPassword.value == "") {
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		if (frm.memberName.value == "") {
			alert("닉네임을 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		
		frm.submit();
		
		}
	
	/* 	function idCheckDo(){
			event.preventDefault();
			if (frm.memberId.value == ""){
				alert("아이디를 입력하세요.");
				frm.memberId.focus();
			}else{
				var id = frm.memberId.value;
				window.open("/DBTest/memberIdCheck.do?id=" + id, "childForm","width=570, height=350, resizable=no");
				frm.idCheck.value="Checked";
			}
		} */
</script>

	<div class="form" align="center">
		<form id="frm" name="frm" action="memberSignin.do" method="post" class="loginForm">
			<h3>회원가입</h3>
			<div class="idForm">
				<input type="text" class="memberId" name="memberId" placeholder="ID" id="memberId">
				<!-- <button class="btn" id="idCheck" name="idCheck" value="unChecked" onclick="idCheckDo()">중복확인</button> -->
				<input type="button" class="btn" id="idCheck" name="idCheck" value="unChecked"></button>
			</div>
			<div class="passForm">
				<input type="password" class="memberPassword" name="memberPassword"
					placeholder="PASSWORD">
			</div>
			<div class="nickForm">
				<input type="text" class="memberName" name="memberName"
					placeholder="NAME">
			</div>
			<div class="addrForm">
				<input type="text" class="memberAddress" name="memberAddress"
					placeholder="ADDRESS">
			</div>
			<input type="button" value="Sign-in" onclick="formCheck()" class="btn">
			<input type="button" value="Go home" class="btn" onclick="location.href='main.do'">
			<div class="bottomText">
				Forget password? <a href="#">find password</a>
			</div>
		</form>
	</div>
