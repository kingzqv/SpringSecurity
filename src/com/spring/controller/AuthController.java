package com.spring.controller;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	
public class AuthController {
	
	/*@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}*/
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,
			@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
            model.addAttribute("error", "不正确的用户名和密码");
        }
        if (logout != null) {
            model.addAttribute("msg", "你已经成功退出");
        }
		return "login";
	}
	
	/*@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}*/
}
