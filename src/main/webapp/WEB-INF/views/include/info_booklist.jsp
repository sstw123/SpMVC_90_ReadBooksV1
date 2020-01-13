<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${rootPath}/css/read-list.css">
<body>
	<button id="book-insert" type="button">도서등록</button>
	<table>
		<tr>
			<th>No.</th>
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>구입일자</th>
			<th>구입가격</th>
		</tr>
		<c:forEach items="${InfoList}" var="info" varStatus="status">
			<tr class="book_record" data-b_code="${info.b_code}">
				<td>${status.count}</td>
				<td>${info.b_code}</td>
				<td>${info.b_name}</td>
				<td>${info.b_auther}</td>
				<td>${info.b_comp}</td>
				<td>${info.b_year}</td>
				<td>${info.b_iprice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>