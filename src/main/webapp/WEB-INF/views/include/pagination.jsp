<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/pagination.css"/>
<article class="page_box">
	<ul class="page_body">
		<c:if test="${pagiDTO.startPageNo > 1}">
			<li class="page_item"><a class="page_link" href="${rootPath}/info/list?currPage=1">처음</a></li>
			<li class="page_item"><a class="page_link">&middot;&middot;&middot;</a></li>
		</c:if>
		
		<c:forEach begin="${pagiDTO.startPageNo}" end="${pagiDTO.endPageNo}" var="pageNo">
			<li class="page_item <c:if test='${pageNo == pagiDTO.currentPageNo}'>active</c:if>"><a class="page_link" href="${rootPath}/info/list?currPage=${pageNo}">${pageNo}</a></li>
		</c:forEach>
		
		<c:if test="${pagiDTO.endPageNo != pagiDTO.lastPageNo}">
			<li class="page_item"><a class="page_link">&middot;&middot;&middot;</a></li>
			<li class="page_item"><a class="page_link" href="${rootPath}/info/list?currPage=${pagiDTO.lastPageNo}">끝</a></li>
		</c:if>
	</ul>
</article>