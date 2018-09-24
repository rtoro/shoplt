/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atomic.shoplt.repository;

import com.atomic.shoplt.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author rtoro
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> 
{

	@Override
	@EntityGraph(attributePaths = {"unit"})
	public Page<Item> findAll(Pageable pageable);
	
	@EntityGraph(attributePaths = {"unit"})
	Page<Item> findByIdLikeAndNameContainingAndBarCodeContainingAndUnitLike(Long id , String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"unit"})
	Page<Item> findByNameContainingAndBarCodeContainingAndUnitLike(String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"unit"})
	Page<Item> findByIdLikeAndNameContainingAndBarCodeContaining(Long id , String name, String barcode, Pageable pageable);
	
	@EntityGraph(attributePaths = {"unit"})
	Page<Item> findByNameContainingAndBarCodeContaining(String name, String barcode,Pageable pageable);

//	List<String> findUnit();
}
