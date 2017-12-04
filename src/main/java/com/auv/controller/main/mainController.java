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
		List<User> allUsers = userBasicService.getAllUserService();
		model.addAttribute("allUsers",allUsers);
		return "pageQuery";
	}
}
