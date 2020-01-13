<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/info_insert_edit.css">
<script src="${rootPath}/js/info_insert_edit.js"></script>

<body>
	<form:form modelAttribute="InfoDTO">
		<fieldset>
			<legend>도서정보 수정</legend>
			
			<div>
				<label for="b_code">도서코드</label><br/>
				<form:input type="text" path="b_code" placeholder="도서코드" maxlength="17" readonly="true" style="background-color: #e2e2e2;"/>
			</div>
			
			<div>
				<label for="b_name">도서명</label><br/>
				<form:input type="text" path="b_name" placeholder="도서명" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_auther">저자</label><br/>
				<form:input type="text" path="b_auther" placeholder="저자" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_comp">출판사</label><br/>
				<form:input type="text" path="b_comp" placeholder="출판사" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_year">구입일자</label><br/>
				<form:input type="text" path="b_year" placeholder="구입일자" maxlength="10"/>
			</div>
			
			<div>
				<label for="b_iprice">구입가격</label><br/>
				<form:input type="text" path="b_iprice" placeholder="구입가격"/>
			</div>
			
			<div>
				<button id="btn_edit_submit" type="button">수정</button>
			</div>
		</fieldset>
	</form:form>
</body>
</html>