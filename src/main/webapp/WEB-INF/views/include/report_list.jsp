<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/info_list.css">
<script src="${rootPath}/js/info_list.js"></script>

<body>
	<div class="button_box">
		<button id="info_insert" type="button">도서등록</button>
	</div>
	<h3>독서록</h3>
	<c:choose>
		<c:when test="${empty ReportList}">
			<p class="noReport">독서록이 없습니다</p>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>독서일자</th>
					<th>한줄소감</th>
					<th>별점</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${ReportList}" var="reportDTO" varStatus="status">
					<tr class="report_record" data-seq="${reportDTO.rb_seq}" data-bcode="${reportDTO.rb_bcode}">
						<td>${reportDTO.rb_date}</td>
						<td>${reportDTO.rb_subject}</td>
						<td>${reportDTO.rb_star}</td>
						<td id="report_edit" data-seq="${reportDTO.rb_seq}">수정</td>
						<td id="report_delete" data-seq="${reportDTO.rb_seq}" data-bcode="${reportDTO.rb_bcode}">삭제</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>