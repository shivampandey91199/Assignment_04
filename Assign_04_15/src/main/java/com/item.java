package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String itemId;

	Double itemTotal;
	int quantity;
	@ManyToOne
	@JoinColumn(name = "item_id")
	Cart cart;

	@Override
	public String toString() {
		return "item [itemId=" + itemId + ", itemTotal=" + itemTotal + ", quantity=" + quantity + ", cart=" + cart
				+ "]";
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
