<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/info_info.css">
<script src="${rootPath}/js/info_info.js"></script>

<body>
	<section class="info_box">
		
		<article class="title">
			<p>도서정보</p>
		</article>
			
		<article id="book_info">
			<p class="book_name">${InfoDTO.b_name}</p>
			<p>${InfoDTO.b_author} 지음 | ${InfoDTO.b_comp} | ${InfoDTO.b_code}</p>
			<p>${InfoDTO.b_year} 구매 | ${InfoDTO.b_iprice}원</p>
		</article>
		
		<article class="button_box">
			<button class="info_button" id="info_edit" data-bcode="${InfoDTO.b_code}" type="button">도서정보 수정</button>
			<button class="info_button" id="info_delete" data-bcode="${InfoDTO.b_code}" type="button">도서정보 삭제</button>
		</article>
		
		
		<article class="title">
			<p>독서록</p>
		</article>
		
		<article id="report_info">
			<c:choose>
				<c:when test="${empty reportInfoDTO}">
					<p class="noReport">독서록이 없습니다</p>
				</c:when>
				<c:otherwise>
					<p>${reportInfoDTO.rb_date} ${reportInfoDTO.rb_stime} | ${reportInfoDTO.rb_rtime}시간 동안 읽음 | ${reportInfoDTO.rb_star}점</p>
					<b>${reportInfoDTO.rb_subject}</b>
					<p>${reportInfoDTO.rb_text}</p>
				</c:otherwise>
			</c:choose>
		</article>
		
		<article class="button_box">
			<button class="info_button" id="report_edit" data-seq="${reportInfoDTO.rb_seq}" type="button">독서록 수정</button>
			<button class="info_button" id="report_delete" data-bcode="${InfoDTO.b_code}" data-seq="${reportInfoDTO.rb_seq}" type="button">독서록 삭제</button>
			<button class="info_button" id="report_write" data-bcode="${InfoDTO.b_code}" type="button">독서록 작성</button>
		</article>
		
		<article class="title">
			<p>독서록 리스트</p>
		</article>
		<%@ include file="/WEB-INF/views/include/report_list.jsp" %>
	</section>
</body>
</html>