package com.netease.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.springboot.model.User;

@Controller
public class TestController {
	@Autowired
	private User user;
	
	@RequestMapping("/user")
	String home(Date date) {
		return user.toString() + "\tdate: " + date;
	}
	
	@RequestMapping("/test")
	String test(Model model) {
		model.addAttribute("items", new User[]{new User(41, "Leng"), new User(1231, "Zhao"), new User(1231, "Yang")});
		Map<String, User> map = new HashMap<String, User>();
		map.put("user1", new User(41, "Leng"));
		map.put("user2", new User(41, "Zhao"));
		map.put("user3", new User(41, "Yang"));
		String test = null;
		String t = " ";
		String s = "";
		model.addAttribute("map", map);
		model.addAttribute("test", test);
		model.addAttribute("t", t);
		model.addAttribute("s", s);
		return "test";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
