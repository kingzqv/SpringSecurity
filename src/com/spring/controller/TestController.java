package com.spring.controller;

import com.spring.entity.Role;
//import com.spring.entity.User;
import com.spring.service.IRoleService;
import com.spring.service.ITestService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


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

	@RequestMapping(value = "/video", method = RequestMethod.GET) 
	public String video(ModelMap model) {
		String path = "\\fold";
		model.addAttribute("path", path);
		System.out.println("start");
		File file = new File("C:\\Users\\vmwin7\\Documents\\eclipse-workspace\\SpringSecurity\\WebContent\\statics" + path);
		if (file.isDirectory()) {
			File[] fileLists = file.listFiles(); // 如果是目录，获取该目录下的内容集合
			for (int i = 0; i < fileLists.length; i++) { // 循环遍历这个集合内容
				if (!fileLists[i].isDirectory()) { // 判断元素是不是一个目录
					if (fileLists[i].getName().endsWith(".mp4")) {
						System.out.println(fileLists[i].getName()); // 输出元素名称
					}
				}
			}
			model.addAttribute("filelist", fileLists);
		} else {
			model.addAttribute("filelist", "该路径无效");
		}
		return "video";
	}

	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public ModelAndView spring() {
		ModelAndView mav = new ModelAndView(testService.test());
		mav.addObject("ts", roleService.findById(1));
		return mav;
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String jsong() {
		return "json";
	}
	
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String jsonp(@RequestBody Role role) {
		return role.toString();
	}

}
