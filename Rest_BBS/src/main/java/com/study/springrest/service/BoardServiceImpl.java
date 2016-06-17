package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.springrest.domain.BoardVO;
import com.study.springrest.persistance.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;
	
	@Override
	public BoardVO get(int board_no) {
		// TODO Auto-generated method stub
		return dao.get(board_no);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(int board_no) {
		dao.delete(board_no);
		
	}
	
}
