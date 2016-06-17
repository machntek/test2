package com.study.springrest.persistance;

import java.util.List;

import com.study.springrest.domain.BoardVO;

public interface BoardDAO {
	public BoardVO get(int board_no);
	public List<BoardVO> getList();
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(int board_no);
	public void increaseReply(int board_no);
}
