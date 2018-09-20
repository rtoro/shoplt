/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.repository;

import com.atomic.shoplt.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rtoro
 */
public interface ItemRepository extends CrudRepository<Item, Long>
{

	Iterable<Item> findAll(Sort sort);

	Page<Item> findAll(Pageable pageable);
}
