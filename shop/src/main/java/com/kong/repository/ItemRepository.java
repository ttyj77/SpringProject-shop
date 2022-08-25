package com.kong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kong.entity.Item;



public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByItemNm(String itemNm);
	
	@Query(value="select* from item where i.item_detail like %:itemDetail% order by i.price desc" , nativeQuery = true)
	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
	
	
	
	
}
