package com.wish.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wish.domain.Wish;

@Controller
public class WishController {

	@RequestMapping(value ="/",method = RequestMethod.GET)
	public String showPage() {
		return "home";
	}
	@RequestMapping(value = "/wish",method = RequestMethod.POST)
	public ModelAndView wishMsg(@Valid @ModelAttribute("wish")  Wish wish) {
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		if(!StringUtils.isEmpty(wish.getMsg())) {
			String msg = "hello "+wish.getMsg()+" Welcome to the OpenShift!!..";
			view.addObject("msg", msg);
			return view;
		}
		return view;
	}
}
