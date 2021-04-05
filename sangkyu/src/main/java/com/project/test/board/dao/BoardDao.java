package com.project.test.board.dao;

import java.util.List;

import com.project.test.board.vo.BoardVo;

public interface BoardDao {

	public void create(BoardVo vo) throws Exception;
	
	public BoardVo read(int bno) throws Exception;
	
	public void update(BoardVo vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardVo> list(int start, int end, String searchOption, String ketword) throws Exception;
	
	public void viewCnt(int bno) throws Exception;

	public int countArticle(String searchOption, String keyword) throws Exception;

}
