package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service;

import java.util.List;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Item;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;

public interface ItemService {
	
	public Item createItem(Item item);

	public Item getItem(String itemName);

	public List<Item> getAllItems();

	public void deleteItem(String itemName);
	
	public Item updateItem(Item item,String itemName);
	
	public void deleteItemById(long itemId);
	
}
