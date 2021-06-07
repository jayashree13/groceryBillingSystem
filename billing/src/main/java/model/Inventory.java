package model;

import java.util.List;

public class Inventory {
    private final List<Item> inventoryList;

    public Inventory(List<Item> inventoryList) {
	this.inventoryList = inventoryList;
    }

    public  Item getItemByItemCode(String itemCode,List<Item> inventoryList) {
	for (Item item : inventoryList) {
	    if (item.getCode().equalsIgnoreCase(itemCode)) {
		return item;
	    }
	}
	return null;
    }

    public List<Item> getInventoryList() {
	return inventoryList;
    }
}
