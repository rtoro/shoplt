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
@Table(name = "location")
public class Location extends AbstractAuditingEntity implements Serializable
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "location")
    private Set<Existance> existance = new HashSet<>();

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
	
	
	
}
