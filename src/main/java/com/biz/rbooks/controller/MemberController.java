package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.service.MemberService;

@RequestMapping("member")
@Controller
public class MemberController {
	
	private final MemberService memberSvc;
	
	@Autowired
	public MemberController(MemberService memberSvc) {
		this.memberSvc = memberSvc;
	}

	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("MODAL", "JOIN");
		return "home";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO) {
		memberSvc.insert(memberDTO);
		
		return "redirect:/info/list";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("MODAL", "LOGIN");
		return "home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, HttpSession httpSession) {
		MemberDTO dbMemberDTO = memberSvc.login(memberDTO);
		if(dbMemberDTO != null) {
			httpSession.setAttribute("MEMBER", memberDTO);
		} else {
			httpSession.removeAttribute("MEMBER");
		}
		
		return "redirect:/info/list";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("MEMBER");
		
		return "redirect:/info/list";
	}

}
