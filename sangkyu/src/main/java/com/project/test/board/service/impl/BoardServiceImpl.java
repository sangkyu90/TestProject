package com.project.test.board.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.project.test.board.dao.BoardDao;
import com.project.test.board.service.BoardService;
import com.project.test.board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	BoardDao boardDao;
	
	@Override
	public void create(BoardVo vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String userId = vo.getUserId();
		
		title = title.replace("<", "&lt");
		title = title.replace("<", "&gt");
		userId = userId.replace("<", "&lt");
		userId = userId.replace("<", "&gt");
		
		//공백처
		title = title.replace(" ", "&nbsp;&nbsp;");
		userId =  userId.replace(" ", "&nbsp;&nbsp;");
		
	content = content.replace("\n", "<br>");
	vo.setTitle(title);
	vo.setContent(content);
	vo.setUserId(userId);
	boardDao.create(vo);

	}

	@Override
	public BoardVo raad(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		// TODO Auto-generated method stub
		boardDao.update(vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDao.delete(bno);
	}

	@Override
	public List<BoardVo> list(int start, int end, String searchOption, String ketword) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.list(start, end, searchOption, ketword);
	}

	@Override
	public void viewCnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		long update_time = 0;
		
		if(session.getAttribute("update_time_"+bno) != null) {
			
			update_time =(Long)session.getAttribute("update_time_"+bno);
		}
		
		long current_time = System.currentTimeMillis();
		
		if(current_time - update_time > 5*1000) {
			boardDao.viewCnt(bno);
			
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.countArticle(searchOption, keyword);
	}

}
