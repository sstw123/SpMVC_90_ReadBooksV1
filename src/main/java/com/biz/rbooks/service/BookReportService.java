package com.biz.rbooks.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookReportDTO;
import com.biz.rbooks.repository.BookReportDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookReportService {
	
	private final BookReportDao reportDao;
	
	@Autowired
	public BookReportService(BookReportDao reportDao) {
		super();
		this.reportDao = reportDao;
	}
	// 생성자 끝
	
	public List<BookReportDTO> selectByBCode(String b_code) {
		return reportDao.selectByBCode(b_code);
	}

	public int insert(BookReportDTO reportDTO, String b_code) {
		reportDTO.setRb_bcode(b_code);//rb_bcode 세팅
		
		// 유효성 검사 rb_date가 없으면 insert하지 않고 임의 숫자 55 return
		if(reportDTO.getRb_date() == null) {
			return 55;
		}
		
		return reportDao.insert(reportDTO);
	}

	public BookReportDTO selectBySeq(long rb_seq) {
		return reportDao.selectBySeq(rb_seq);
	}

	public int update(BookReportDTO reportDTO) {
		return reportDao.update(reportDTO);
	}

	public int delete(long rb_seq) {
		return reportDao.delete(rb_seq);
	}

	public BookReportDTO setDefaultInsert(BookReportDTO reportDTO, String b_code) {
		
		reportDTO = new BookReportDTO();
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		reportDTO.setRb_bcode(b_code);
		
		reportDTO.setRb_date(sd.format(date));
		
		reportDTO.setRb_stime(st.format(date));
		
		if(reportDTO.getRb_star() == null) {
			reportDTO.setRb_star("3");
		}
		
		return reportDTO;
	}
	
}
