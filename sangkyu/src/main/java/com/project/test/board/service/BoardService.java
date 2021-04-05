package com.project.test.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.project.test.board.vo.BoardVo;

public interface BoardService {

	public void create(BoardVo vo)throws Exception;
	
	public BoardVo raad(int bno)throws Exception;
	
	public void update(BoardVo vo)throws Exception;
	
	public void delete(int bno)throws Exception;
	
	public List<BoardVo> list(int start, int end, String searchOption, String ketword)throws Exception;
	
	public void viewCnt(int bno, HttpSession session)throws Exception;

	public int countArticle(String searchOption, String keyword) throws Exception;
	

	
}
