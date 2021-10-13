package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Item findByItemName(String itemName);

}
