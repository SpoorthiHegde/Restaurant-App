package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "menu_items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private long itemId;
	private String itemName;
	private String itemDesc;
	private int price;
	private String image;

//---------------------------------------Mapping---------------------
	@OneToMany (cascade = CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "item")
	@JsonIgnore
	private List<Cart> carts;

//----------------------------------------Constructors----------------------

	public Item() {
		super();
	}

	public Item(String itemName, String itemDesc, int price) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.price = price;
	}

//-------------------------- Getters and Setters------------------------
	

	public String getItemName() {
		return itemName;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
//------------------------------------------------------------------------------------------------------
	
	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setItem(this);
		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setItem(null);
		return cart;
	}

}
