package com.xuel.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuel.manager.service.DubboService;

@RequestMapping("/xuel")
@Controller
public class DubboController {
    @Autowired
	private DubboService  service;
  
    
    @RequestMapping("/dubbo")
    @ResponseBody
    public List show(){
    	
     return service.show();
     
    }
}
