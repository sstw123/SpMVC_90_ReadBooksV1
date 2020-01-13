<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${rootPath}/css/report_insert_edit.css">
<script src="${rootPath}/js/report_insert_edit.js"></script>

<body>
	<form:form modelAttribute="reportDTO">
		<fieldset>
			<legend>독서록 수정</legend>
			
			<div>
				<form:hidden path="rb_bcode"/>
			</div>
			
			<div>
				<label for="rb_date">독서일자</label>
				<form:input type="date" path="rb_date" placeholder="독서일자"/>
			</div>
			
			<div>
				<label for="rb_stime">독서시작시각</label>
				<form:input type="time" path="rb_stime" placeholder="독서시작시각"/>
			</div>
			
			<div>
				<label for="rb_rtime">독서시간</label>
				<form:input type="number" path="rb_rtime" placeholder="독서시간"/>
			</div>
			
			<div>
				<label for="rb_subject">한줄소감</label>
				<form:input type="text" path="rb_subject" placeholder="한줄소감"/>
			</div>
			
			<div>
				<label for="rb_text">긴줄소감</label>
				<form:textarea type="text" path="rb_text" placeholder="긴줄소감"/>
			</div>
			
			<div>
				<label for="rb_star">별점</label>
				<form:input type="number" path="rb_star" placeholder="별점" min="1" max="5" value="${reportDTO.rb_star}" />
			</div>
			
			<div>
				<button id="btn_submit" type="button">작성</button>
			</div>
		</fieldset>
	</form:form>
</body>
</html>