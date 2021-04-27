<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	function formClose(b){
		if(!b) {
			opener.frm.memberPassword.value="";
			opener.frm.memberPassword.focus();
			window.close();
		}else{
			opener.frm.memberId.value="";
			opener.frm.memberId.focus();
			window.close();
		}
	}
</script>

	<div align="center">
		<h1>${param.id }는 ${msg }</h1>
		<button type="button" onclick="formClose(${check})"> 확인 </button>
	</div>
