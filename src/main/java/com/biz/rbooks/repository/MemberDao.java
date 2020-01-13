package com.biz.rbooks.repository;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.MemberDTO;

public interface MemberDao {
	
	@Select("select count(*) from tbl_member")
	public int memberCount();
	
	@Select("select * from tbl_member where m_id = #{m_id}")
	public MemberDTO selectById(String m_id);
	
	@InsertProvider(type=MemberSQL.class, method="member_insert_sql")
	public int insert(MemberDTO memberDTO);
	
	@UpdateProvider(type=MemberSQL.class, method="member_update_sql")
	public int update(MemberDTO memberDTO);

}
