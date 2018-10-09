package com.ssm.sample.controller.construction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.sample.controller.base.BaseController;
@Controller
@RequestMapping({ "/main" })
public class constructionController extends BaseController{	
		@RequestMapping(value = "construction")
		public ModelAndView construction() {
			ModelAndView mv = this.getModelAndView();	
			System.out.println("asda");		
			System.out.println("dsada");
			mv.setViewName("construction/construction");
			return mv;
		}
		@RequestMapping(value = "newsintroduction01")
		public ModelAndView newsintroduction01() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("construction/xinwentonggao01");
			return mv;
		}
		@RequestMapping(value = "newsintroduction02")
		public ModelAndView newsintroduction02() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("construction/xinwentonggao02");
			return mv;
		}
		@RequestMapping(value = "/test")
		public ModelAndView aa() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("cgy_jsp/test");
			return mv;
		}
		@RequestMapping(value = "/test2")
		public ModelAndView bb() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("cgy_jsp/test2");
			return mv;
		}
		@RequestMapping(value = "/cssDemo")
		public ModelAndView cssDemo() {
			ModelAndView mv = this.getModelAndView();			
			mv.setViewName("Sample/cssdemo");
			return mv;
		}
}
