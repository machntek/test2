package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistance.BoardDAO;
import com.study.springrest.persistance.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	@Inject
	private BoardDAO boardDao;
	
	@Override
	public ReplyVO get(int reply_no) {
		// TODO Auto-generated method stub
		return dao.get(reply_no);
	}

	@Override
	public List<ReplyVO> getList(int board_no) {
		// TODO Auto-generated method stub
		return dao.getList(board_no);
	}

	//@Transactional	//하나의 트랜잭션으로 묶어서 처리하겠다
	@Override
	public void insert(ReplyVO vo) {
		boardDao.increaseReply(vo.getBoard_no());
		
		dao.insert(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int reply_no) {
		dao.delete(reply_no);
		
	}

	@Override
	public List<ReplyVO> getListPage(int board_no, Criteria cri) {
		// TODO Auto-generated method stub
		return dao.getListPage(board_no, cri);
	}

	@Override
	public int getTotlaCount(int board_no) {
		// TODO Auto-generated method stub
		return dao.getTotlaCount(board_no);
	}



}
