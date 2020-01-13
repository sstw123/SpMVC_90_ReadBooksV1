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
			<th>No</th>
			<th>도서코드</th>
			<th>도서명</th>
			<th>독서일자</th>
			<th>한줄소감</th>
			<th>별점</th>
		</tr>
		<c:forEach items="${InfoList}" var="infoDTO" varStatus="status">
			<tr class="record" data-b_code="${infoDTO.b_code}">
				<td>${status.count}</td>
				<td>${infoDTO.b_code}</td>
				<td>${infoDTO.b_name}</td>
				<td>${infoDTO.bookReportList[0].rb_date}</td>
				<td>${infoDTO.bookReportList[0].rb_subject}</td>
				<td>${infoDTO.bookReportList[0].rb_star}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>