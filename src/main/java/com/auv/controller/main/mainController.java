package com.auv.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auv.model.User;
import com.auv.service.serviceInterface.userBasicService;

@Controller
public class mainController {
	@Autowired
	userBasicService userBasicService;
	@RequestMapping("main")
	public String pageQuery(Model model) {
//		User user = userBasicService.getUserByIdService(1);
		List<User> allUsers = userBasicService.getAllUserService();
//		model.addAttribute("user", user);
		model.addAttribute("allUsers",allUsers);
		System.out.println(allUsers.size());
		return "pageQuery";
	}
}
