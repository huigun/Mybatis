package com.huigwon.study0429.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huigwon.study0429.dao.IDao;
import com.huigwon.study0429.dto.ContentDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping(value = "write")
	public String write(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<ContentDto> dtos = dao.listDao();
		model.addAttribute("list", dtos);
		
		return "list";
	}
	
	@RequestMapping(value="/")
	public String home() {
		return "redirect:list";
	}
	
	@RequestMapping(value="delete")
	public String delete(HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		
		dao.deleteDao(mid);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="modify")
	public String modify(HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.modifyDao(mid, mwriter, mcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="mview")
	public String mview(HttpServletRequest request, Model model) {
		String mid = request.getParameter("mid");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<ContentDto> dtos = dao.mlistDao(mid);
		model.addAttribute("list", dtos);
		
		
		return "mview";
	}
}
