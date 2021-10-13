package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Item;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
//---------------------------------User and Admin -------------------------------------------
	
	//-------------------Get all items----------------
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return this.itemService.getAllItems();
	}
	
//---------------------------Admin------------------------------------------------------------
	
	//-------------------Create Item------------------
	@PostMapping("/")
	public Item createItem(@RequestBody Item item) {
		return this.itemService.createItem(item);
	}
	
	//--------------Get Item by ItemName---------------
	@GetMapping("/{itemName}")
	public Item getItemByItemName(@PathVariable String itemName) {
		return this.itemService.getItem(itemName);
	}

    //--------------Delete Item by ItemName------------
	@DeleteMapping("/{itemName}")
	public void deleteItemByUserName(@PathVariable String itemName) {
		this.itemService.deleteItem(itemName);
	}

    //--------------Update Item by ItemName------------	
	@PutMapping("/{itemName}")
	public Item updateItemByItemName(@RequestBody Item item, @PathVariable String itemName) {
		return this.itemService.updateItem(item, itemName);
	}
	
}
