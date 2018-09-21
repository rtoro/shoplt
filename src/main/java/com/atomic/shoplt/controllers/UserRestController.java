/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import com.atomic.shoplt.domain.UserApp;
import com.atomic.shoplt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rtoro
 */
@RestController
@RequestMapping("/rest/users")
public class UserRestController
{
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	Page<UserApp> employeesPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

}
