package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.service.BookReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("rest/report")
@RestController
public class BookReportRestController {
	
	private final BookReportService reportSvc;
	
	@Autowired
	public BookReportRestController(BookReportService reportSvc) {
		this.reportSvc = reportSvc;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(@RequestParam("rb_seq") String str_rb_seq, @RequestParam("bookCode") String b_code) {
		
		long rb_seq = Long.valueOf(str_rb_seq);
		int ret = reportSvc.delete(rb_seq);//rb_seq값을 기준으로 DB에서 독서록 데이터 삭제
		
		return ret + "";
	}

}
