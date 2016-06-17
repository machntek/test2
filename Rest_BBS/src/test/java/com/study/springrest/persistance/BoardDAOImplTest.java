package com.study.springrest.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOImplTest {
	@Inject
	private BoardDAO dao;
	@Test
	public void test() {
		System.out.println("Test DAO = " + dao);
	}
	
	//@Test
	public void insertTest() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setUser_name("id");
		vo.setTitle("나라네");
		vo.setContent("내용");
		dao.insert(vo);
	}
	
	@Test
	public void getTest() throws Exception {
		BoardVO vo = dao.get(6);
		System.out.println("이름 : "+vo.getUser_name());
	}
	
	@Test
	public void getListTest() throws Exception {
		List<BoardVO> list = dao.getList();
		Iterator<BoardVO> it = list.iterator();
		while(it.hasNext()) {
			BoardVO vo = it.next();
			System.out.println("이름 : "+vo.getUser_name());
		}
	}


	@Test
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setUser_name("업데이트이름");
		vo.setContent("업데이트test@gmail.com");
		vo.setBoard_no(2);
		vo.setTitle("업데이트제목");
		
		dao.update(vo);
	}
	@Test
	public void delete() {
		int no = 3;
		
		dao.delete(no);
	}
}
