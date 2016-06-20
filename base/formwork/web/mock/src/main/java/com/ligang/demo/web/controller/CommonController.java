package com.ligang.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author:gang.li
 * @date:2016年6月3日 下午3:33:50 
 * @version 1.0.0 
 */
@Controller
public class CommonController {
	
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info(">>>>>>>>>index");
		return "index";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse resp){
		
		return "login";
	}

}
