package com.spring.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller @RequestMapping("/") @Slf4j
public class HomeController {
	
		
	@GetMapping("/")
	public String loginGet() {
		log.info("홈페이지 요청");
		return "home";
	}
}

