/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rodol
 */
@Controller
public class ItemController
{
		@RequestMapping(value="/item/add", method = RequestMethod.POST)
		public ModelAndView addItem()
		{
			return null;
		}
}
