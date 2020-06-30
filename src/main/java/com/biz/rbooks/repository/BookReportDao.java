package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.BookReportDTO;

public interface BookReportDao {
	
	@Select("select * from TBL_READ_BOOK order by rb_bcode")
	public List<BookReportDTO> selectAll();
	
	@Select("select * from TBL_READ_BOOK where RB_BCODE = #{b_code,jdbcType=VARCHAR}")
	public List<BookReportDTO> selectByBCode(String b_code);

	@Select("select * from TBL_READ_BOOK where RB_SEQ = #{rb_seq,jdbcType=VARCHAR}")
	public BookReportDTO selectBySeq(long rb_seq);
	
	@Select("select count(*) from TBL_READ_BOOK where RB_BCODE = #{b_code,jdbcType=VARCHAR}")
	public long countReport(String b_code);
	
	@InsertProvider(type=BookReportSQL.class, method="report_insert_sql")
	public int insert(BookReportDTO reportDTO);
	
	@UpdateProvider(type=BookReportSQL.class, method="report_update_sql")
	public int update(BookReportDTO reportDTO);
	
	@Delete("delete from TBL_READ_BOOK where RB_SEQ = #{rb_seq,jdbcType=VARCHAR}")
	public int delete(long rb_seq);
	
}
