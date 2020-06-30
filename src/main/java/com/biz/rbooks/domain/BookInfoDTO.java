package com.biz.rbooks.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookInfoDTO {
	
	private String b_code;//	varchar2(20 byte)
	private String b_name;//	nvarchar2(125 char)
	private String b_author;//	nvarchar2(125 char)
	private String b_comp;//	nvarchar2(125 char)
	private String b_year;//	varchar2(10 byte)
	private String b_iprice;//	number
	
	private List<BookReportDTO> bookReportList;
	private String srch_opt;
	private String srch;
	private PaginationDTO pageDTO;

}
