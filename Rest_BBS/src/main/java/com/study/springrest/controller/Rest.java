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
	// /����/ R ���
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView aaa = new ModelAndView();//�����Ϳ� ȭ���� ���� ó���� �� �ִ� ��ü
		aaa.setViewName("list");
		List<BoardVO> list = service.getList();
		aaa.addObject("list", list);
		return aaa;	
	}
	
	
	
	
	//  /����/�۹�ȣ	��
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("board_no") Integer board_no) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("detail");
		BoardVO vo = service.get(board_no);
		aaa.addObject("vo", vo);
		return aaa;
	}
	
	// /����/new  �۾��� ������
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value ="/{board_no}", method= RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		service.delete(board_no);
		return new ModelAndView("redirect:/rest");
	}
	
	// /����/   method=post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView insert(BoardVO vo) {
		service.insert(vo);
		return new ModelAndView("redirect:/rest");
	}
	
}
