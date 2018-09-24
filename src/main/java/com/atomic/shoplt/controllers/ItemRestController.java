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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		String id = dtRequest.getFilters().get("id");
		String name = dtRequest.getFilters().get("name");
		String barCode = dtRequest.getFilters().get("barCode");
		String unit_id = dtRequest.getFilters().get("unit_id");
		name = name == null ? "" : name;
		barCode = barCode == null ? "" : barCode;

		Page page = null;
		if(id != null)
		{
			if(unit_id != null)
			{
				page = itemRepository.findByIdLikeAndNameContainingAndBarCodeContainingAndUnitLike(Long.valueOf(id), name, barCode, Integer.valueOf(unit_id), dtRequest.getPageRequest());
			}
			else
			{
				page = itemRepository.findByIdLikeAndNameContainingAndBarCodeContaining(Long.valueOf(id), name, barCode, dtRequest.getPageRequest());
			}
		}
		else
		{
			if(unit_id != null)
			{
				page = itemRepository.findByNameContainingAndBarCodeContainingAndUnitLike(name, barCode, Integer.valueOf(unit_id), dtRequest.getPageRequest());
			}
			else
			{
				page = itemRepository.findByNameContainingAndBarCodeContaining(name, barCode, dtRequest.getPageRequest());
			}
		}

		DataTablesResponse<Item> dtResponse = new DataTablesResponse<>(page);
		dtResponse.setDraw(dtRequest.getDraw());

		return dtResponse;
	}

}
