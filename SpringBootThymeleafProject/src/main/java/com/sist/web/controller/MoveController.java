package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.MoveDAO;
import com.sist.web.entity.MoveEntity;

import java.util.*;
@Controller
@RequestMapping("/move")
public class MoveController {
	@Autowired
	private MoveDAO dao;
	@RequestMapping("move_find")
	public String move_find(Model model,String page, String fd) {
		if(page==null) page="1";
		if(fd==null)fd="서울";
		int curpage = Integer.parseInt(page);
		int rowSize = 8;
		int start = (rowSize*curpage)-rowSize;
		
		int totalpage = dao.moveFindTotalPage(fd);
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		List<MoveEntity> list = dao.moveFindListData(fd, start);
		
		model.addAttribute("fd", fd);
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "move/move_find");
		return "main";
	}
}
