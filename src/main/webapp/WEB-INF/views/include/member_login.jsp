<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${rootPath}/css/member_login.css">
<script src="${rootPath}/js/member_login.js"></script>

<form method="POST" action="${rootPath}/member/login" class="login_form">
	<div id="close_box">
		<span id="close">X</span>
	</div>
	<h2>로그인</h2>
	
	<input type="text" name="m_id" id="login_id" placeholder="ID">
	<input type="password" name="m_password" id="login_password" placeholder="비밀번호">
	<h3 id="login_alert"></h3>
	
	<button type="button" id="login_login">로그인</button>
	<button type="button" id="login_join">회원가입</button>
	<!-- button type을 button으로 설정하면 action으로 submit하는 기능 꺼짐 -->
</form>