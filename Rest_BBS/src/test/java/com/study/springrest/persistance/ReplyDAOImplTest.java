package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.BoardVO;
import com.study.springrest.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	@Inject
	private ReplyDAO dao;
	@Test
	public void test() {
		System.out.println("Test DAO = " + dao);
	}
	
	//@Test
	public void insertTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setUser_name("id");
		vo.setContent("내용");
		vo.setBoard_no(6);
		dao.insert(vo);
	}
	
	@Test
	public void getTest() throws Exception {
		ReplyVO vo = dao.get(1);
		System.out.println("reply이름1 : "+vo.getUser_name());
	}
	
	@Test
	public void getListTest() throws Exception {
		List<ReplyVO> list = dao.getList(6);
		Iterator<ReplyVO> it = list.iterator();
		while(it.hasNext()) {
			ReplyVO vo = it.next();
			System.out.println("reply이름 : "+vo.getUser_name());
		}
	}


//	@Test
//	public void updateTest() {
//		BoardVO vo = new BoardVO();
//		vo.setUser_name("업데이트이름");
//		vo.setContent("업데이트test@gmail.com");
//		vo.setBoard_no(2);
//		vo.setTitle("업데이트제목");
//		
//		dao.update(vo);
//	}
	@Test
	public void delete() {
		int no = 3;
		
		dao.delete(no);
	}
}
