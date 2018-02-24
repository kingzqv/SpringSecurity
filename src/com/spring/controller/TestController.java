package com.spring.controller;

//import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.service.IRoleService;
import com.spring.service.ITestService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
	@Autowired
	private ITestService testService;
	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET) // 声明请求的方法，默认为GET方法
	// 定义printWelcome方法，返回String类型对象
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello World");
		return "helloworld";// 返回helloworld，交由ViewResolver解析
	}

	//@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView spring() {
		ModelAndView mav=new ModelAndView(testService.test());
		mav.addObject("ts", roleService.findById(1));
		return mav;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roleList", roleService.findAll());
		return "test";
	}

	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String error(@Validated User user, BindingResult br) {

		if (br.hasErrors()) {
			System.out.println(user);
			return "test";
		}
		System.out.println(user);
		return "test";
	}

}
