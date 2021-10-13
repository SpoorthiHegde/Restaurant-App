package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Exception.ResourceNotFoundException;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Item;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return this.itemRepository.save(item);
	}

	@Override
	public Item getItem(String itemName) {
		return this.itemRepository.findByItemName(itemName);
	}

	@Override
	public List<Item> getAllItems() {
		return this.itemRepository.findAll();
	}

	@Override
	public void deleteItem(String itemName) {
		 Item item = this.itemRepository.findByItemName(itemName);
		itemRepository.delete(item);
	}

	@Override
	public Item updateItem(Item item, String itemName) {
		Item updatedItem = this.itemRepository.findByItemName(itemName);
		updatedItem.setItemName(item.getItemName());
		updatedItem.setItemDesc(item.getItemDesc());
		updatedItem.setPrice(item.getPrice());
		updatedItem.setImage(item.getImage());
		updatedItem = this.itemRepository.save(updatedItem);
		return updatedItem;
	}

	@Override
	public void deleteItemById(long itemId) {
		Item item = this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("User doesn't exist with id : " + itemId));
		itemRepository.delete(item);
	}
}
