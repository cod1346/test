package com.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller @RequestMapping("/login") @Slf4j
public class LoginController {
	
	@GetMapping("/login")
	public void loginGet(String login) {
		log.info("로그인페이지 요청"+login);
	}
	//회원가입 페이지 요청
	@GetMapping("/register/register")
	public void register() {
		log.info("회원가입페이지 요청");
	}
	@PostMapping("/register/sendMail")
	public void sendMail(String email) {
		log.info("메일전송요청 메일 : "+email);
	}


}
