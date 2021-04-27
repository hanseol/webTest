<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div align="center">
		<h1>공지 사항 등록</h1>
		<form action="noticeRegister.do" method="post">
			<table border="1">
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="6" cols="90" id="content" name="content"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="등록"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소"/>&nbsp;&nbsp;&nbsp;
		</form>
	</div>
