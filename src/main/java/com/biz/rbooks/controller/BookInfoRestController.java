package com.biz.rbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.service.BookInfoService;

@RequestMapping("rest/info")
@RestController
public class BookInfoRestController {
	
	private final BookInfoService infoSvc;
	
	@Autowired
	public BookInfoRestController(BookInfoService infoSvc) {
		this.infoSvc = infoSvc;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String bookDelete(@RequestParam("bookCode")String b_code) {
		
		int ret = infoSvc.delete(b_code);
		
		return ret + "";
	}
	
	@RequestMapping(value="checkBcode", method=RequestMethod.POST)
	public String checkBcode(@RequestParam("bookCode")String b_code) {
		
		if(infoSvc.selectByBCode(b_code) == null) {
			return "NULL";
		} else {
			return "EXISTS";
		}
	}

}
