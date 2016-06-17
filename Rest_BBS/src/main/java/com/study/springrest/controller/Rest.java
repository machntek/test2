package com.study.springrest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.BoardVO;
import com.study.springrest.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/rest")
public class Rest {
	
	private static final Logger logger = LoggerFactory.getLogger(Rest.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Inject
	private BoardService service;
	// /유닛/ R 목록
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView aaa = new ModelAndView();//데이터와 화면을 같이 처리할 수 있는 객체
		aaa.setViewName("list");
		List<BoardVO> list = service.getList();
		aaa.addObject("list", list);
		return aaa;	
	}
	
	
	
	
	//  /유닛/글번호	상세
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("board_no") Integer board_no) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("detail");
		BoardVO vo = service.get(board_no);
		aaa.addObject("vo", vo);
		return aaa;
	}
	
	// /유닛/new  글쓰기 페이지
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value ="/{board_no}", method= RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		service.delete(board_no);
		return new ModelAndView("redirect:/rest");
	}
	
	// /유닛/   method=post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView insert(BoardVO vo) {
		service.insert(vo);
		return new ModelAndView("redirect:/rest");
	}
	
}
