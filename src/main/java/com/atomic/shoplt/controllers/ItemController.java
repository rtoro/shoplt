/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rodol
 */
@Controller
@RequestMapping("/item")
public class ItemController
{

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addItem()
	{
		return null;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listUsers(Principal principal)
	{
		ModelAndView mv = new ModelAndView("/user/list");
		return mv;
	}
}
