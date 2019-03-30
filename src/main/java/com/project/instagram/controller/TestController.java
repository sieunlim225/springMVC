package com.project.instagram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/")
	public String testing() {
		
		return "main/index";
	}
	
	@RequestMapping("/test")
	public String test() {
		
		return "board/board";
	}
}
