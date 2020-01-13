<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${rootPath}/css/report_insert_edit.css">
<script src="${rootPath}/js/report_insert_edit.js"></script>

<body>
	<form method="POST">
		<fieldset>
			<legend>독서록 작성</legend>
			
			<div>
				<input type="hidden" name="rb_bcode" id="rb_bcode" value="${reportInsertDTO.rb_bcode}"/>
			</div>
			
			<div>
				<label for="rb_date">독서일자</label>
				<input type="date" name="rb_date" id="rb_date" placeholder="독서일자" value="${reportInsertDTO.rb_date}"/>
			</div>
			
			<div>
				<label for="rb_stime">독서시작시각</label>
				<input type="time" name="rb_stime" id="rb_stime" placeholder="독서시작시각" value="${reportInsertDTO.rb_stime}"/>
			</div>
			
			<div>
				<label for="rb_rtime">독서시간</label>
				<input type="number" name="rb_rtime" id="rb_rtime" placeholder="독서시간"/>
			</div>
			
			<div>
				<label for="rb_subject">한줄소감</label>
				<input type="text" name="rb_subject" id="rb_subject" placeholder="한줄소감"/>
			</div>
			
			<div>
				<label for="rb_text">긴줄소감</label>
				<textarea name="rb_text" id="rb_text" placeholder="긴줄소감"></textarea>
			</div>
			
			<div>
				<label for="rb_star">별점</label>
				<input type="number" name="rb_star" id="rb_star" placeholder="별점" min="1" max="5" value="${reportInsertDTO.rb_star}" />
			</div>
			
			<div>
				<button id="btn_submit" type="button">작성</button>
			</div>
		</fieldset>
	</form>
</body>
</html>