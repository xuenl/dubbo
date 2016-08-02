package com.xuel.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xuel.manager.po.Student;
import com.xuel.manager.po.User;
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
    @RequestMapping("/index")
    public ModelAndView page(){
    	User u= new User();
    	ModelAndView mv=new ModelAndView();
    	u.setUsername("dsfdsfdsf");
    	mv.setViewName("NewFile");
    	mv.addObject(u);
    	Student s = new Student();
    	s.setId(44);
//    	mv.addObject(s);
    	mv.addObject("s", s);
    	return mv;
    }
}
