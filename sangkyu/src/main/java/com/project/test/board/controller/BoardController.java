package com.project.test.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.test.board.service.BoardService;
import com.project.test.board.vo.BoardPager;
import com.project.test.board.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue ="title")String searchOption,
							 @RequestParam(defaultValue ="")String keyword,
							 @RequestParam(defaultValue ="1")int curPage) throws Exception{
		
		int count = boardService.countArticle(searchOption, keyword);
		
		BoardPager boardPager = new BoardPager(count , curPage);
		
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<BoardVo> list = boardService.list(start,end, searchOption, keyword);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("board/list");
			mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping(value = "write.do",method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String insert(@ModelAttribute BoardVo vo) throws Exception{
		boardService.create(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		boardService.viewCnt(bno, session);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/view");
		
		mv.addObject("vo", boardService.raad(bno));
		
		return mv;
		
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVo vo) throws Exception{
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno)throws Exception{
		boardService.delete(bno);
		return "redirect:list.do";
	}
	
	
}
