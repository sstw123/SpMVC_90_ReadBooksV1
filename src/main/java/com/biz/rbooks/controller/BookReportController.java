package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rbooks.domain.BookReportDTO;
import com.biz.rbooks.service.BookReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("reportDTO")
@RequestMapping("report")
@Controller
public class BookReportController {
	
	private final BookReportService reportSvc;
	
	@Autowired
	public BookReportController(BookReportService reportSvc) {
		super();
		this.reportSvc = reportSvc;
	}

	@ModelAttribute("reportDTO")
	public BookReportDTO reportDTO() {
		return new BookReportDTO();
	}
	// 생성자 끝
	
	// 사용하지 않는 메소드
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		List<BookReportDTO> reportList = reportSvc.selectAll();
		
		model.addAttribute("RESULT", "report_list");
		model.addAttribute("ReportList", reportList);
		
		return "home";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert(@RequestParam("bookCode") String b_code, Model model) {
		// Insert에는 @ModelAttribute가 들어갈 필요가 없기 때문에
		// @ModelAttribute BookReportDTO reportDTO를 넣지 않는다
		// @ModelAttribute를 넣으면 수정 버튼 클릭 후 뒤로가기 등을 눌렀을 때 값이 유지되어 나타나기 때문

		BookReportDTO reportInsertDTO = new BookReportDTO();

		//rb_bcode, 독서일자, 독서시작시간, 기본별점 세팅후 반환받기
		reportInsertDTO = reportSvc.setDefaultInsert(reportInsertDTO, b_code);
		
		model.addAttribute("RESULT", "report_insert");
		model.addAttribute("reportInsertDTO", reportInsertDTO);
		
		//독서록 쓰기를 눌렀다가 뒤로가기를 눌러도, SessionAttributes의 reportDTO의 값을 null로 바꿔서
		//독서록이 하나도 없다면 info_info.jsp에 표시 안되도록 하기
		model.addAttribute("reportDTO", null);
		
		return "home";//report_insert.jsp에는 기본값들이 세팅된 reportDTO값이 전부 들어간다
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(@RequestParam("bookCode") String b_code, BookReportDTO reportDTO) {
		
		int ret = reportSvc.insert(reportDTO, b_code);//독서록 DB Insert
		
		return "redirect:/info/info?bookCode=" + b_code;
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(@RequestParam("rb_seq") String str_rb_seq, Model model) {
		long rb_seq = Long.valueOf(str_rb_seq);
		
		BookReportDTO reportDTO = reportSvc.selectBySeq(rb_seq);//get으로 입력받은 rb_seq값으로 DB에서 레코드 가져오기
		
		model.addAttribute("RESULT", "report_edit");
		model.addAttribute("reportDTO", reportDTO);
		
		return "home";//수정할 reportDTO값 report_insert로 보내기
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute("reportDTO") BookReportDTO reportDTO) {
		
		int ret = reportSvc.update(reportDTO);//report_insert에서 입력한 값을 POST 메소드의 reportDTO로 수신하고 그걸로 독서록 DB 업데이트
		
		return "redirect:/info/info?bookCode=" + reportDTO.getRb_bcode();//도서코드를 기준으로 다시 도서정보로 돌아가기
	}
	
}
