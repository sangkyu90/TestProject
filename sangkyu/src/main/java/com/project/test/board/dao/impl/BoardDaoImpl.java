package com.project.test.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.test.board.dao.BoardDao;
import com.project.test.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Inject
	SqlSession SqlSession;
	
	@Override
	public void create(BoardVo vo) throws Exception {
		SqlSession.insert("board.insert",vo);
	}

	@Override
	public BoardVo read(int bno) throws Exception {
		return SqlSession.selectOne("board.view",bno);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		SqlSession.update("board.update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		SqlSession.delete("board.delete", bno);
	}

	@Override
	public List<BoardVo> list(int start, int end, String searchOption, String ketword) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("ketword", ketword);
		
		map.put("start", start);
		map.put("end",end);
		return SqlSession.selectList("board.list",map);
	}

	@Override
	public void viewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update("board.viewCnt", bno);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return SqlSession.selectOne("board.countArticle" , map);
	}

}
