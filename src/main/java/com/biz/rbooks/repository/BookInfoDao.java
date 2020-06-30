package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.BookInfoDTO;
import com.biz.rbooks.domain.BookReportDTO;
import com.biz.rbooks.domain.PaginationDTO;

public interface BookInfoDao {
	
	
	@Select("select * from tbl_books order by b_name")
	@Results(
			value = {
				@Result(property = "b_code", column = "b_code"),
				@Result(property = "bookReportList", column = "b_code", javaType=List.class, many = @Many(select = "getBookReport"))
			})
	public List<BookInfoDTO> selectAll();
	
	@Select("select * from tbl_books where b_code = #{b_code,jdbcType=VARCHAR}")
	@Results(
			value = {
				@Result(property = "b_code", column = "b_code"),
				@Result(property = "bookReportList", column = "b_code", javaType=List.class, many = @Many(select = "getBookReport"))
			})
	public BookInfoDTO selectByBCode(String b_code);
	
	@Select("select * from tbl_read_book where rb_bcode = #{b_code,jdbcType=VARCHAR} order by rb_seq desc")
	public List<BookReportDTO> getBookReport(String b_code);
	
	public BookInfoDTO selectByBCodePage(@Param("b_code")String b_code, @Param("pageDTO")PaginationDTO pageDTO);
	
	public List<BookReportDTO> selectReportsByPage(@Param("b_code")String b_code, @Param("offset")int offset, @Param("limit")int limit);
	
	@InsertProvider(type=BookInfoSQL.class, method="book_insert_sql")
	public int insert(BookInfoDTO bookDTO);
	
	@UpdateProvider(type=BookInfoSQL.class, method="book_update_sql")
	public int update(BookInfoDTO bookDTO);
	
	@Delete("delete from tbl_books where b_code = #{b_code,jdbcType=VARCHAR}")
	public int delete(String b_code);

	@Select("select count(*) from tbl_books")
	public long countAll();

	public List<BookInfoDTO> selectBooksBySrchPage(@Param("pageDTO")PaginationDTO pageDTO, @Param("srch_opt")String srch_opt, @Param("srch")String srch);

}