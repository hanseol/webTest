<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>공지사항 관리</h3>
<div class="row">
	<!-- 목록시작 -->
	<div class="col-md-12 col-lg-8">
		<table class="table">
			<thead>
			<tr align="center">
				<th>순번</th>
				<th>타이틀</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
	</div>
	<!-- 목록 끝 -->
	
	
	
	<!-- 등록 시작 -->
	<div class="col-md-12 col-lg-4">
		<form id="frm" name="frm" action="noticeRegister.do" method="post">
			<table class="table table-bordered border-primary">
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="6" cols="90" id="content" name="content"></textarea></td>
				</tr>
			</table>
			<input id="btnSave" class="btn btn-primary" type="button" value="등록"/>
			<input id="btnReset" class="btn btn-warning" type="button" value="취소"/>
			<input id="btnList" class="btn btn-secondary" type="button" value="홈"/>
		</form>
	</div>
	<!-- 등록 끝 -->
</div>
<script src="./js/notice.js"></script>