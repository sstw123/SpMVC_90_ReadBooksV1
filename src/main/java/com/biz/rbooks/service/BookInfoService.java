package com.biz.rbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookInfoDTO;
import com.biz.rbooks.repository.BookInfoDao;

@Service
public class BookInfoService {
	
	private final BookInfoDao infoDao;

	@Autowired
	public BookInfoService(BookInfoDao infoDao) {
		super();
		this.infoDao = infoDao;
	}
	
	public List<BookInfoDTO> selectAll() {
		return infoDao.selectAll();
	}

	public BookInfoDTO selectByBCode(String b_code) {
		return infoDao.selectByBCode(b_code);
	}

	public int insert(BookInfoDTO infoDTO) {
		return infoDao.insert(infoDTO);
	}

	public int update(BookInfoDTO infoDTO) {
		return infoDao.update(infoDTO);
	}

	public int delete(String b_code) {
		return infoDao.delete(b_code);
	}

}
