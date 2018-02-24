package com.spring.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entity.User;
//import com.spring.entity.Role;
import com.spring.service.IUserService;
import com.spring.service.IRoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		model.addAttribute("user", userService.findAll());
		return "user/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roleList", roleService.findAll());
		return "user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "user") @Validated User user, BindingResult br, String[] rs, Model model) {
		if (br.hasErrors() || rs == null) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError er : errors) {
				System.out.println("field:" + er.getField() + ",code:" + er.getCode() + ",message:"	+ er.getDefaultMessage());
			}
			return "user/add";
		}

		for (String r : rs) {
			user.getRoles().add(roleService.findByName(r));
		}
		System.out.println(user);
		
		//userService.save(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("roleList", roleService.findAll());
		return "user/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @ModelAttribute(value = "user") @Validated User user, BindingResult br, String[] rs, Model model) {
		if (br.hasErrors() || rs == null) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError er : errors) {
				System.out.println("field:" + er.getField() + ",code:" + er.getCode() + ",message:"	+ er.getDefaultMessage());
			}
			return "user/update";
			//return "user/update/" + Integer.toString(id);
		}

		for (String r : rs) {
			user.getRoles().add(roleService.findByName(r));
		}
		System.out.println(user);

		//userService.update(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		//userService.delete(id);
		return "redirect:/user/list";
	}

}
