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
	@EntityGraph(attributePaths = {"existance","unit"})
	public Page<Item> findAll(Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByIdLikeAndNameLikeAndBarCodeLikeAndUnitLike(Integer id , String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByNameLikeAndBarCodeLikeAndUnitLike(String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByIdLikeAndNameLikeAndBarCodeLike(Integer id , String name, String barcode, Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByNameLikeAndBarCodeLike(String name, String barcode,Pageable pageable);
	
//	List<String> findUnit();
}
