package com.registration.controller;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.bean.Login;
import com.registration.bean.Register;
import com.registration.dao.RegisterDAO;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(Map<String, Object> model) {
		Register userForm = new Register();
		model.put("userForm", userForm);
		return "registrationForm";
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("userForm") Register member,
			Map<String, Object> model) {
		System.out.println("---");
		System.out.println(member.getFirstName());
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");

		RegisterDAO registerDAO = (RegisterDAO) context.getBean("registerDAO");
		registerDAO.insert(member);

		Register customer1 = registerDAO.findByCustomerId(1);
		System.out.println(customer1);

		return "memberDetail";
	}

	@RequestMapping(value = "/loginMember", method = RequestMethod.POST)
	public String loginEmployee(@ModelAttribute("userForm") Login login,
			Map<String, Object> model) {
		System.out.println("---");
		System.out.println(login.getUserName());
		System.out.println(login.getLoginPassword());
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		RegisterDAO registerDAO = (RegisterDAO) context.getBean("registerDAO");
		int resutlt = registerDAO.findCustomer(login.getUserName(),
				login.getLoginPassword());
		System.out.println(resutlt);
		if (resutlt == 1) {
			return "success";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("userForm") Login login,
			Map<String, Object> model) {
		return "index";
	}

}
