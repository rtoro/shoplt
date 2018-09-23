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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private String barcode;
	
	@Column(name = "price_unit")
	private float priceunit;

	@ManyToOne(targetEntity = Unit.class ,fetch = FetchType.LAZY)
	private Unit unit;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "item",fetch = FetchType.LAZY)
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
		return priceunit;
	}

	public void setPriceUnit(float priceUnit)
	{
		this.priceunit = priceUnit;
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
		return barcode;
	}

	public void setBarCode(String barCode)
	{
		this.barcode = barCode;
	}

	public Unit getUnit()
	{
		return unit;
	}

	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}
	
}
