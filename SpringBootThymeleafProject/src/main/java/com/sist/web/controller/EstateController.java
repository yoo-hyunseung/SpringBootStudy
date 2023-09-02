package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.EstateDAO;
import com.sist.web.entity.*;


import java.util.*;

@Controller
///estate/estate_list
@RequestMapping("/estate")
public class EstateController {
	@Autowired
	private EstateDAO dao;
	@GetMapping("estate_list")
	public String estate_list(Model model,String page,String etype) {
		if(page==null)page="1";
		if(etype==null)etype="1";
		int curpage = Integer.parseInt(page);
		int rowSize=8;
		int start = (rowSize*curpage)-rowSize;
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		List<EstateEntity> list = dao.estateTypeListData(Integer.parseInt(etype), curpage);
		for(EstateEntity vo : list) {
			StringTokenizer st = new StringTokenizer(vo.getImg(),"^");
			vo.setImg(st.nextToken());
			String name = vo.getName();
			if(name.length()>10)
				name=name.substring(0,11)+"...";
			vo.setName(name);
		}
		int totalpage= dao.estateTypeTotalPage(Integer.parseInt(etype));
		if(endPage>totalpage)endPage=totalpage;
		model.addAttribute("etype", etype);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "estate/estate_list");
		return "main";
	}
}
