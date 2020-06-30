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
		var MEMBER= "${MEMBER}"
	</script>
	
	<script src="${rootPath}/js/home.js"></script>
	<script src="${rootPath}/js/nav.js"></script>
	
</head>
<body>
	<header id="header">
		<h1>독서록</h1>
	</header>
	
	<nav>
		<ul>
			<li id="home">홈</li>
			<li id="booklist">도서목록</li>
			<c:choose>
				<c:when test="${empty MEMBER}">
					<li class="login-box" id="login">로그인</li>
					<li id="join">회원가입</li>
				</c:when>
				<c:otherwise>
					<li class="login-box" id="m_id">${MEMBER.m_id} 님, 환영합니다!</li>
					<li id="logout">로그아웃</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	
	<section id="result">
		<c:choose>
			<c:when test="${RESULT == 'info_list'}">
				<c:set var="URL" value="${rootPath}/info/list?"/>
				<article id="info_list">
					<%@ include file="/WEB-INF/views/include/info_list.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_booklist'}">
				<c:set var="URL" value="${rootPath}/info/booklist?"/>
				<article id="info_booklist">
					<%@ include file="/WEB-INF/views/include/info_booklist.jsp" %>
				</article>
			</c:when>
			
			<c:when test="${RESULT == 'info_info'}">
				<c:set var="URL" value="${rootPath}/info/info?bookCode=${InfoDTO.b_code}&"/>
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
	
	<section>
		<article id="login_modal">
			<%@ include file = "/WEB-INF/views/include/member_login.jsp" %>
		</article>
		
		<article id="join_modal">
			<%@ include file = "/WEB-INF/views/include/member_join.jsp" %>
		</article>
	</section>
	
</body>
</html>