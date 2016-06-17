package com.study.springrest.service;

import java.util.List;

import com.study.springrest.domain.BoardVO;

public interface BoardService {
	public BoardVO get(int board_no);
	public List<BoardVO> getList();
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(int board_no);
}
