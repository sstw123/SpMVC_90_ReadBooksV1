<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initian-scale=1">
	<title>독서록</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${rootPath}/css/home.css">
	<link rel="stylesheet" type="text/css" href="${rootPath}/css/nav.css">

	<script>
		var rootPath = "${rootPath}"
		var MODAL= "${MODAL}"
	</script>
	
	<script src="${rootPath}/js/home.js"></script>
	
</head>
<body>
	<header id="header">
		<h1>독서록</h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="${rootPath}/info/list">홈</a></li>
			<li><a href="${rootPath}/info/booklist">도서목록</a></li>
			<c:choose>
				<c:when test="${empty MEMBER}">
					<li class="login-box"><a href="${rootPath}/member/login" id="login">로그인</a></li>
					<li><a href="${rootPath}/member/join" id="join">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li class="login-box" id="m_id">${MEMBER.m_id} 님, 환영합니다!</li>
					<li><a href="${rootPath}/member/logout" id="logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	
	<section id="result">
		<c:choose>
			<c:when test="${RESULT == 'info_list'}">
				<article id="info_list">
					<%@ include file="/WEB-INF/views/include/info_list.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_booklist'}">
				<article id="info_booklist">
					<%@ include file="/WEB-INF/views/include/info_booklist.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_info'}">
				<article id="info_info">
					<%@ include file="/WEB-INF/views/include/info_info.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_insert'}">
				<article id="info_insert">
					<%@ include file="/WEB-INF/views/include/info_insert.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_edit'}">
				<article id="info_edit">
					<%@ include file="/WEB-INF/views/include/info_edit.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'report_list'}">
				<article id="report_list">
					<%@ include file="/WEB-INF/views/include/report_list.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'report_insert'}">
				<article id="report_write">
					<%@ include file="/WEB-INF/views/include/report_insert.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'report_edit'}">
				<article id="report_update">
					<%@ include file="/WEB-INF/views/include/report_edit.jsp" %>
				</article>
			</c:when>
		</c:choose>
	</section>
	
	<section id="login_modal">
		<c:if test="${MODAL == 'LOGIN'}">
			<%@ include file = "/WEB-INF/views/include/member_login.jsp" %>
		</c:if>
		<c:if test="${MODAL == 'JOIN'}">
			<%@ include file = "/WEB-INF/views/include/member_join.jsp" %>
		</c:if>
	</section>
	
</body>
</html>