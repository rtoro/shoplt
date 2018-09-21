/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import com.atomic.shoplt.domain.Item;
import com.atomic.shoplt.repository.ItemRepository;
import com.atomic.shoplt.util.datatable.DataTablesRequest;
import com.atomic.shoplt.util.datatable.DataTablesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rtoro
 */
@RestController
@RequestMapping("/rest/item")
public class ItemRestController
{

	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Page<Item> employeesPageable(Pageable pageable)
	{
		return itemRepository.findAll(pageable);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public DataTablesResponse<Item> employeesPageable(@RequestBody DataTablesRequest dtRequest)
	{
		Pageable pageable = new PageRequest(0, 1);

		DataTablesResponse<Item> dtResponse = new DataTablesResponse<>(itemRepository.findAll(dtRequest));
		dtResponse.setDraw(dtRequest.getDraw());
		
			
		return dtResponse;
	}

}
