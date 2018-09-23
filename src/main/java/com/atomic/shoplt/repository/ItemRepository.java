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
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByIdLikeAndNameLikeAndBarcodeLikeAndUnitLike(Integer id , String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByNameLikeAndBarcodeLikeAndUnitLike(String name, String barcode, Integer unit,Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByIdLikeAndNameLikeAndBarcodeLike(Integer id , String name, String barcode, Pageable pageable);
	
	@EntityGraph(attributePaths = {"existance","unit"})
	Page<Item> findByNameLikeAndBarcodeLike(String name, String barcode,Pageable pageable);
	
//	List<String> findUnit();
}
