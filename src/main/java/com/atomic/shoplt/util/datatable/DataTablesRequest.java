/*
 * Copyright 2016 Eveoh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atomic.shoplt.util.datatable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * @author Erik van Paassen
 */
public class DataTablesRequest implements Pageable
{

	private int draw;
	private int start;
	private int length;
	private DataTablesSearch search;
	private List<DataTablesColumn> columns = Collections.emptyList();
	private List<DataTablesOrder> order = Collections.emptyList();

	public int getDraw()
	{
		return draw;
	}

	public void setDraw(int draw)
	{
		this.draw = draw;
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public DataTablesSearch getSearch()
	{
		return search;
	}

	public void setSearch(DataTablesSearch search)
	{
		this.search = search;
	}

	public List<DataTablesColumn> getColumns()
	{
		return columns;
	}

	public void setColumns(List<DataTablesColumn> columns)
	{
		this.columns = columns;
	}

	public List<DataTablesOrder> getOrder()
	{
		return order;
	}

	public void setOrder(List<DataTablesOrder> order)
	{
		this.order = order;
	}

	//<editor-fold defaultstate="collapsed" desc="Pageable impl">
	@Override
	public int getPageNumber()
	{
		if(start == 0)
		{
			return 0;
		}
		else
		{
			return start / length;
		}
	}

	@Override
	public int getPageSize()
	{
		return length;
	}

	@Override
	public long getOffset()
	{
		return (long) getPageNumber() * (long) getPageSize();
	}

	@Override
	public Sort getSort()
	{
		List<Order> orders = new ArrayList<>();
		order.forEach((dataTablesOrder) ->
		{
			orders.add(new Order(Sort.Direction.valueOf(dataTablesOrder.getDir().name().toUpperCase()), columns.get(dataTablesOrder.getColumn()).getName()));
		});
		Sort sort= Sort.by(orders);
		return sort;
	}

	@Override
	public Pageable next()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Pageable previousOrFirst()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Pageable first()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean hasPrevious()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	//</editor-fold>
}