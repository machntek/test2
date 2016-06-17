package com.study.springrest.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	
	//memberMaper.xmlÀÌ¶û ¸ÅÇÎµÊ
	private static final String namespace ="com.study.springrest.mappers.BoardMapper";

	@Override
	public BoardVO get(int board_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".get", board_no); 
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getList"); 
	}

	@Override
	public void insert(BoardVO vo) {
		sqlSession.insert(namespace+ ".insert", vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		sqlSession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(int board_no) {
		sqlSession.delete(namespace + ".delete", board_no);
		
	}

	@Override
	public void increaseReply(int board_no) {
		sqlSession.update(namespace + ".increaseReply", board_no);
		
	}
}
