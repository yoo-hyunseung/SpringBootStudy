package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
import java.util.*;
@Controller
public class MainController {
	@Autowired
	private EstateDAO dao;
	@GetMapping("/")
	public String main_main(Model model) {
		List<EstateEntity> list = dao.estateHomeData();
		for(EstateEntity vo : list) {
			vo.setImg(vo.getImg().substring(0,vo.getImg().indexOf("^")));
		}
		List<EstateEntity> mList =dao.estateComData("매매");
		List<EstateEntity> jList =dao.estateComData("전세");
		List<EstateEntity> wList =dao.estateComData("월세");
		
		model.addAttribute("main_html", "main/home");
		model.addAttribute("list", list);
		model.addAttribute("mList", mList);
		model.addAttribute("jList", jList);
		model.addAttribute("wList", wList);
		return "main";
	}
}
