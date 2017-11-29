package com.auv.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.viva4u.pojo.User;
//import com.viva4u.service.userService;

@Controller
public class loginController {
//	@Autowired()
	/*@Qualifier("userserviceimpl")
	userService userService;*/
	@RequestMapping("/")
	public String loginmain() {
		return "main";
	}
	/*@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	@SuppressWarnings("unused")
	@RequestMapping("/loginSuc")
	public String  loginSuccess(@RequestParam("name") String uname,@RequestParam("password") String pwd,Model model) {
		User user = userService.getUserByNameService(uname);
		System.out.println(user);
		System.out.println(user.getUserName());
		
		if(user!=null) {
			if(pwd.equals(user.getPassword())) {
				model.addAttribute("name", uname);
				return "loginSuc";
			}else {
				model.addAttribute("message", "瀵嗙爜涓嶆纭�");
			}
		}else {
			model.addAttribute("message", "鐢ㄦ埛涓嶅瓨鍦�");
		}
		return "main";
	}*/
}
