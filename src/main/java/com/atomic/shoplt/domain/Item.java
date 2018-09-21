/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rodol
 */
@Entity
@Table(name = "item")
public class Item extends AbstractAuditingEntity implements Serializable
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "description", length = 50)
	private String description;
	
	@Column(name = "bar_code", length = 200)
	private String barCode;
	
	@Column(name = "price_unit")
	private float priceUnit;
		
	@Column(name = "unit")
	private String unit;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "item")
    private Set<Existance> existance = new HashSet<>();

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public float getPriceUnit()
	{
		return priceUnit;
	}

	public void setPriceUnit(float priceUnit)
	{
		this.priceUnit = priceUnit;
	}

	public Set<Existance> getExistance()
	{
		return existance;
	}

	public void setExistance(Set<Existance> existance)
	{
		this.existance = existance;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getBarCode()
	{
		return barCode;
	}

	public void setBarCode(String barCode)
	{
		this.barCode = barCode;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	
}
