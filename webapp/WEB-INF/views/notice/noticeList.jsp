<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
   function formSubmit(id) {
      frm.id.value = id;
      frm.submit();
   }
</script>

<div>
	<div>
		<h1>공지사항</h1>
	</div>
	<form id="frm" name="frm" action="noticeContent.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr align="center">
				<th>순번</th>
				<th>타이틀</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="vo" items="${notices }">
				<tr onclick="formSubmit(${vo.id})">
					<td align="center">${vo.id }</td>
					<td align="center">${vo.title }</td>
					<td align="center">${vo.wdate }</td>
					<td align="center">${vo.hit }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>