<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/info_list.css">
<script src="${rootPath}/js/info_list.js"></script>

<body>
	<div class="button_box">
		<button id="info_insert" type="button">도서등록</button>
	</div>
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
		<c:forEach items="${InfoList}" var="infoDTO" varStatus="status">
			<tr class="book_record" data-b_code="${infoDTO.b_code}">
				<td>${status.count}</td>
				<td>${infoDTO.b_code}</td>
				<td>${infoDTO.b_name}</td>
				<td>${infoDTO.b_auther}</td>
				<td>${infoDTO.b_comp}</td>
				<td>${infoDTO.b_year}</td>
				<td>${infoDTO.b_iprice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>