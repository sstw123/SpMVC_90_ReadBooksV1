<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${rootPath}/css/member_join.css">
<script src="${rootPath}/js/member_join.js"></script>

<form method="POST" action="${rootPath}/member/join" class="join_form" id="join_form">
	<div id="close_box">
		<span id="close">&times;</span>
	</div>
	<h2>회원가입</h2>
	<h3 id="join_alert"></h3>
	
	<label for="m_id">ID</label><br/>
	<input id="join_id" type="text" name="m_id"><br/>
	
	<label for="join_pw1">비밀번호</label><br/>
	<input class="join_pw" id="join_pw1" type="password" name="m_password"><br/>
	
	<label for="join_pw2">비밀번호 확인</label><br/>
	<input class="join_pw" id="join_pw2" type="password" name="m_passwordCheck"><br/>
	
	<div id="pwCheckFail">비밀번호가 일치하지 않습니다</div>
	<button id="join_join" type="button">회원가입</button>
</form>