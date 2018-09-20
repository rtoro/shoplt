package com.atomic.shoplt.controllers;

import com.atomic.shoplt.domain.User;
import com.atomic.shoplt.repository.UserRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rtoro
 */
@Controller
@RequestMapping("/users")
public class UserController
{

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/list")
	public ModelAndView listUsers(Principal principal)
	{
		List<User> users = userRepository.findAll();
		ModelAndView mv = new ModelAndView("/user/list");
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(Principal principal)
	{
		ModelAndView mv = new ModelAndView("user/list");
		mv.addObject("user_added", principal);
		return mv;
	}

	

}
