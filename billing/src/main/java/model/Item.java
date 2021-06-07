package model;

public class Item {
    private String code;
    private String name;
    private Category category;
    private double unitPrice;

    public Item(String code, String name, Category category, double unitPrice) {
	this.code = code;
	this.name = name;
	this.category = category;
	this.unitPrice = unitPrice;
    }

    public String getCode() {
	return code;
    }

    public Category getCategory() {
	return category;
    }

    public double getUnitPrice() {
	return unitPrice;
    }

    @Override public String toString() {
	return "Item{" + "code=" + code + ", name='" + name + '\'' + ", category=" + category + ", unitPrice=" + unitPrice + '}';
    }
}
