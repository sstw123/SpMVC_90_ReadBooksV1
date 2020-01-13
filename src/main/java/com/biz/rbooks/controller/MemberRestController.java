package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.service.MemberService;

@RequestMapping("rest/member")
@RestController
public class MemberRestController {
	
	private final MemberService memberSvc;
	
	@Autowired
	public MemberRestController(MemberService memberSvc) {
		this.memberSvc = memberSvc;
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO) {
		int ret = memberSvc.insert(memberDTO);
		
		if(ret > 0) {
			return "JOIN_SUCCESS";
		} else {
			return "JOIN_FAIL";
		}
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, HttpSession httpSession) {
		
		MemberDTO dbMemberDTO = memberSvc.login(memberDTO);
		if(dbMemberDTO != null) {
			httpSession.setAttribute("MEMBER", memberDTO);
			return "LOGIN_SUCCESS";
		} else {
			httpSession.removeAttribute("MEMBER");
			return "LOGIN_FAIL";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public String logout(HttpSession httpSession) {
		
		httpSession.removeAttribute("MEMBER");
		return "LOGOUT";
	}
	
	
	@RequestMapping(value="isMemberExists", method=RequestMethod.POST)
	public String isMemberExists(String m_id) {
		if(memberSvc.isMemberExists(m_id) != null) {
			return "EXISTS"; 
		} else {
			return "NULL";
		}
	}

}
