<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/search.css">
<article>
	<form id="srch_form" action="${URL}">
		<select name="srch_opt">
			<option value="all">전체</option>
			<option value="isbn">ISBN</option>
			<option value="b_name">도서명</option>
		</select>
		
		<input name="srch">
		
		<button>검색</button>
	</form>
</article>