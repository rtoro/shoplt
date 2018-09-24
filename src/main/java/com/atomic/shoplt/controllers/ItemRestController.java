/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.controllers;

import com.atomic.shoplt.domain.Item;
import com.atomic.shoplt.domain.Unit;
import com.atomic.shoplt.repository.ItemRepository;
import com.atomic.shoplt.repository.UnitRepository;
import com.atomic.shoplt.util.datatable.DataTablesRequest;
import com.atomic.shoplt.util.datatable.DataTablesResponse;
import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
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
	private UnitRepository unitRepository;

	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Page<Item> employeesPageable(Pageable pageable)
	{
		return itemRepository.findAll(pageable);
	}

	@RequestMapping(value = "/units", method = RequestMethod.GET)
	public List<Unit> units()
	{
		return (List<Unit>) unitRepository.findAll();
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public DataTablesResponse<Item> employeesPageable(@RequestBody DataTablesRequest dtRequest)
	{
		StringBuilder queryMethod = new StringBuilder("");
		if(!dtRequest.getFilters().isEmpty())
		{
			queryMethod.append("findBy");
			dtRequest.getFilters().forEach((name, valueToSerch) ->
			{
				queryMethod.append(StringUtils.capitalize(name)).append("Like").append("And");
			});
			queryMethod.substring(0, queryMethod.length() - 3);
		}
		else
		{
			queryMethod.append("findAll");
		}
		try
		{
			Method method = itemRepository.getClass().getMethod(queryMethod.toString());
		}
		catch(SecurityException | NoSuchMethodException e)
		{

		}

		DataTablesResponse<Item> dtResponse = new DataTablesResponse<>(itemRepository.findByNameLikeAndBarCodeLike("%%", "%%", dtRequest.getPageRequest()));
		dtResponse.setDraw(dtRequest.getDraw());

		return dtResponse;
	}

}
