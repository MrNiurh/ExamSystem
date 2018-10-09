package com.ssm.sample.controller.construction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
@Controller
public class testController extends BaseController{	
		
		@RequestMapping(value = "/testValidate")
		public ModelAndView testValidate() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("testValidate");
			return mv;
		}
		
		@RequestMapping(value = "main/demo")
		public ModelAndView demo() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("Demo/demo005");
			return mv;
		}
	
}
