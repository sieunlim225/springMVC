package com.mvc.project.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.project.service.TestService;

@Controller
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private TestService testService;
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
	@RequestMapping(value="/test")
	public String test() {
		logger.info("logger TEST");
		
		//DB test 
		String get = testService.test();
		logger.debug("DB TEST" + get);
		System.out.println(get);
		
		//@mapper test auto mapper injection
		List<String> list = testService.getList();
		System.out.println(list.size());
		
		//tx test
		//int result = testService.insertTest();
		
		return "test";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model) {
		
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		model.addAttribute("googleUrl", url);
		return "login";
	}
	
	// 구글 Callback호출 메소드
		@RequestMapping(value = "/login/redirect", method = { RequestMethod.GET, RequestMethod.POST })
		public String googleCallback(Model model, @RequestParam String code) throws IOException {
			System.out.println("여기는 googleCallback");

			return "redirect";
		}
}
