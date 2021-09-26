package com.anand.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.spring.springmvcorm.user.entity.User;
import com.anand.spring.springmvcorm.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("registrationPage")
	public String showRegistrationPage() {

		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
		int result = userService.save(user);
		model.addAttribute("result", "User Created with id: " + result);
		return "userReg";
	}

	@RequestMapping(value = "getUsers")
	public String getUsers(ModelMap model) {
		List<User> showAllUsers = userService.showAll();
		model.addAttribute("showAllUsers", showAllUsers);
		return "displayUser";
	}

	@RequestMapping(value = "validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {

		User user = userService.getUser(id);
		String msg = "";
		if (user != null) {
			msg = id + " User Already Exist";
		}
		return msg; // Since this is not a view that we are sending it's just a response to a ajax
					// call so we have to specify that by using a annotation in the method body just
					// before the data type. so then spring will not try to resolve it thinking it
					// as a view
	}

}
