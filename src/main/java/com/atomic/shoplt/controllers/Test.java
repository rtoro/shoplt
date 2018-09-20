/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rtoro
 */
@RestController
public class Test
{
	
	
	@Autowired
	private PasswordEncoder pw;
	
	@RequestMapping(value = "/pass")
	public String getPassword(@RequestParam(defaultValue="admin") String pass)
	{
		return pw.encode(pass);
	}
}
