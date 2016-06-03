package com.ligang.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author:gang.li
 * @date:2016年6月3日 下午3:33:50 
 * @version 1.0.0 
 */
@Controller
public class BasedController {
	
	@RequestMapping("/index")
	public String index(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse resp){
		
		return "login";
	}

}
