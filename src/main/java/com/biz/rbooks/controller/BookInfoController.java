package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.BookInfoDTO;
import com.biz.rbooks.domain.BookReportDTO;
import com.biz.rbooks.domain.PaginationDTO;
import com.biz.rbooks.service.BookInfoService;
import com.biz.rbooks.service.BookReportService;
import com.biz.rbooks.service.PaginationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("info")
@Controller
public class BookInfoController {
	
	private final BookInfoService infoSvc;
	private final BookReportService reportSvc;
	private final PaginationService pageSvc;
	// 생성자 끝

	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, String srch_opt, String srch, @RequestParam(value="currPage",required=false,defaultValue="1") int currPageNo) {
		
		long totalCount = infoSvc.countAll();
		PaginationDTO pageDTO = pageSvc.getPagination(totalCount, currPageNo);
		model.addAttribute("PAGE_DTO", pageDTO);
		
		List<BookInfoDTO> infoList = infoSvc.selectBooksBySrchPage(pageDTO, srch_opt, srch);
		
		model.addAttribute("RESULT", "info_list");
		model.addAttribute("InfoList", infoList);
		
		return "home";
	}
	
	@RequestMapping(value="booklist", method=RequestMethod.GET)
	public String booklist(Model model, String srch_opt, String srch, @RequestParam(value="currPage",required=false,defaultValue="1") int currPageNo) {
		
		long totalCount = infoSvc.countAll();
		PaginationDTO pageDTO = pageSvc.getPagination(totalCount, currPageNo);
		model.addAttribute("PAGE_DTO", pageDTO);
		
		List<BookInfoDTO> infoList = infoSvc.selectBooksBySrchPage(pageDTO ,srch_opt, srch);
		
		model.addAttribute("RESULT", "info_booklist");
		model.addAttribute("InfoList", infoList);
		
		return "home";
	}
	
	@RequestMapping(value="info", method=RequestMethod.GET)
	public String bookInfo(@RequestParam("bookCode")String b_code, Model model,
							@RequestParam(name="rb_seq", required=false)String str_rb_seq ,
							@RequestParam(value="currPage",required=false,defaultValue="1") int currPageNo) {
		long rb_seq = 0;
		
		long totalCount = reportSvc.countReport(b_code);
		PaginationDTO pageDTO = pageSvc.getPagination(totalCount, currPageNo);
		model.addAttribute("PAGE_DTO", pageDTO);
		
		//BookInfoDTO infoDTO = infoSvc.selectByBCode(b_code);//도서정보
		BookInfoDTO infoDTO = infoSvc.selectByBCodePage(b_code, pageDTO);//도서정보
		
		List<BookReportDTO> reportList = infoDTO.getBookReportList();
		
		if(str_rb_seq != null) {
			//독서록의 rb_seq가 쿼리로 왔다면 독서록 정보 보여주기
			rb_seq = Long.valueOf(str_rb_seq);
			BookReportDTO reportDTO = reportSvc.selectBySeq(rb_seq);
			model.addAttribute("reportInfoDTO", reportDTO);
		} else {
			//독서록의 rb_seq가 쿼리로 안왔다면
			if(reportList == null || reportList.size() < 1) {
				//독서록이 하나도 없으면 독서록 정보 안보여주기
				model.addAttribute("reportInfoDTO", null);
			} else {
				//독서록이 있다면 가장 위에 있는 독서록 정보 보여주기
				model.addAttribute("reportInfoDTO", reportList.get(0));
			}
		}
		
		model.addAttribute("RESULT", "info_info");
		model.addAttribute("InfoDTO", infoDTO);//도서정보
		model.addAttribute("ReportList", reportList);//아래에 보여줄 독서록 리스트
		
		return "home";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String bookInsert(Model model) {
		// Insert에는 @ModelAttribute가 들어갈 필요가 없기 때문에 @ModelAttribute BookInfoDTO infoDTO를 넣지 않는다 
		// @ModelAttribute를 넣으면 수정 버튼 클릭 후 뒤로가기 등을 눌렀을 때 값이 유지되어 나타나기 때문
		
		model.addAttribute("RESULT", "info_insert");
		
		return "home";//insert화면 진입
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String bookInsert(BookInfoDTO infoDTO) {
		
		infoSvc.insert(infoDTO);//POST로 받은 infoDTO 값 도서정보 DB에 insert
		
		return "redirect:/info/list";//리스트로 돌아가기
		
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String bookEdit(@RequestParam("bookCode")String b_code, Model model) {
		
		BookInfoDTO infoDTO = infoSvc.selectByBCode(b_code);//수정 버튼 클릭시 get으로 받은 b_code로 DB에서 레코드 가져오기
		
		model.addAttribute("RESULT", "info_edit");//home.jsp에서 c:when 태그를 이용해 수정 창 표시하도록
		model.addAttribute("InfoDTO", infoDTO);//jsp에 표시할 수 있도록 infoDTO 값 넘겨주기, 스프링 form태그를 이용해 따로 ${InfoDTO.~~~} 하나하나 설정해주지 않고 바로 form에 값 넣어주기
		
		return "home";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String bookEdit(BookInfoDTO infoDTO) {
		infoSvc.update(infoDTO);//form에서 POST로 받은 infoDTO 값으로 도서정보 DB update
		
		return "redirect:/info/info?bookCode=" + infoDTO.getB_code();//b_code를 기준으로 도서정보 상세화면으로 redirect
	}
	
}
