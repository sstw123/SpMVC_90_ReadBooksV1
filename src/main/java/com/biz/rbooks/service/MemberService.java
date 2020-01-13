package com.biz.rbooks.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.repository.MemberDao;

@Service
public class MemberService {
	
	private final MemberDao memberDao;
	private final BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public MemberService(MemberDao memberDao, BCryptPasswordEncoder passwordEncoder) {
		this.memberDao = memberDao;
		this.passwordEncoder = passwordEncoder;
	}
	// -------------------------- bean 생성자 끝-----------------------------
	
	public int insert(MemberDTO memberDTO) {
		// 입력된 memberDTO를 DB에 insert하기 전 password 암호화
		String cryptPW = passwordEncoder.encode(memberDTO.getM_password());
		memberDTO.setM_password(cryptPW);
		
		return memberDao.insert(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		
		String request_m_id = memberDTO.getM_id();
		String request_m_password = memberDTO.getM_password();
		
		MemberDTO dbMemberDTO = memberDao.selectById(request_m_id);
		
		if(dbMemberDTO != null) {
			String dbPW = dbMemberDTO.getM_password();
			if(passwordEncoder.matches(request_m_password, dbPW)) {
				// 로그인 성공시
				// 마지막 로그인 날짜 DB에 업데이트하기
				Date date = new Date();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				dbMemberDTO.setM_login_date(sd.format(date));
				this.update(dbMemberDTO);
				
				// dbMemberDTO 컨트롤러로 리턴
				return dbMemberDTO;
			}
		} 
		return null;
	}
	
	public int update(MemberDTO memberDTO) {
		return memberDao.update(memberDTO);
	}
	
	public MemberDTO isMemberExists(String m_id) {
		return memberDao.selectById(m_id);
	}
	
}
