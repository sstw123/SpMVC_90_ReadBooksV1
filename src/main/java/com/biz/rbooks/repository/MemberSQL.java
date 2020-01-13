package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	
	public String member_insert_sql() {
		
		return new SQL() {
			{
				INSERT_INTO("tbl_member");
				
				INTO_COLUMNS("m_id");
				INTO_COLUMNS("m_password");
				INTO_COLUMNS("m_login_date");
				INTO_COLUMNS("m_rem");
				
				INTO_VALUES("#{m_id,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_password,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_login_date,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_rem,jdbcType=VARCHAR}");
			}
		}.toString();
		
	}
	
	
	public String member_update_sql() {
		
		return new SQL() {
			{
				UPDATE("tbl_member");
				
				WHERE("m_id = #{m_id,jdbcType=VARCHAR}");
				SET("m_password = #{m_password,jdbcType=VARCHAR}");
				SET("m_login_date = #{m_login_date,jdbcType=VARCHAR}");
				SET("m_rem = #{m_rem,jdbcType=VARCHAR}");
			}
		}.toString();
		
	}
}
