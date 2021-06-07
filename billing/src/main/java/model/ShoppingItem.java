package model;

public class ShoppingItem {
    private Item item;
    private double quantity;

    public ShoppingItem(Item item, double quantity) {
	this.item = item;
	this.quantity = quantity;
    }

    public Item getItem() {
	return item;
    }

    public double getQuantity() {
	return quantity;
    }

    @Override public String toString() {
	return "ShoppingItem{" + "item=" + item + ", quantity=" + quantity + '}';
    }
}
