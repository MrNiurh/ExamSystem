package com.ssm.sample.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
@Controller
@RequestMapping({ "/main" })
public class homeController extends BaseController{	
	@RequestMapping(value = "home")
	public ModelAndView home() {
		ModelAndView mv = this.getModelAndView();					
		mv.setViewName("Demo/demo005");
		return mv;
	}
	@RequestMapping(value="home01")
	public ModelAndView home2(){
		ModelAndView mv=this.getModelAndView();
		mv.setViewName("home/homecopy");
		return mv;
	}
}
