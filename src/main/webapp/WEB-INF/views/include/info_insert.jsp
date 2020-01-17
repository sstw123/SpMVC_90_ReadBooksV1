<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/info_insert_edit.css">
<script src="${rootPath}/js/info_insert_edit.js"></script>

<body>
	<form method="POST" id="info_form">
		<fieldset>
			<legend>도서 등록</legend>
			
			<div>
				<label for="b_code">도서코드</label><br/>
				<input type="text" id="b_code" name="b_code" placeholder="도서코드" maxlength="17"/>
			</div>
			
			<div>
				<label for="b_name">도서명</label><br/>
				<input type="text" id="b_name" name="b_name" placeholder="도서명" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_auther">저자</label><br/>
				<input type="text" id="b_auther" name="b_auther" placeholder="저자" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_comp">출판사</label><br/>
				<input type="text" id="b_comp" name="b_comp" placeholder="출판사" maxlength="125"/>
			</div>
			
			<div>
				<label for="b_year">구입일자</label><br/>
				<input type="text" id="b_year" name="b_year" placeholder="구입일자" maxlength="10"/>
			</div>
			
			<div>
				<label for="b_iprice">구입가격</label><br/>
				<input type="text" id="b_iprice" name="b_iprice" placeholder="구입가격"/>
			</div>
			
			<div>
				<button id="btn_insert_submit" type="button">작성</button>
			</div>
		</fieldset>
	</form>
</body>
</html>