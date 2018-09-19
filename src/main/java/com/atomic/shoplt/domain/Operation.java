/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rodol
 */
@Entity
@Table(name = "operation")
public class Operation extends AbstractAuditingEntity
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "detail", length = 250)
	private String detail;
	
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    private OperationType operationType;
	
    @ManyToMany
    @JoinTable(
        name = "operation_item",
        joinColumns = {@JoinColumn(name = "operation_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    private Set<Item> items = new HashSet<>();

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public Set<Item> getItems()
	{
		return items;
	}

	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
}
