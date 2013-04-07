package com.mek.mcloud.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public String welcome() {
            
            return "index"; 
            
	}
}
