package model;

import java.util.Map;

public class BillPerItem {
    private Integer id;
    ShoppingItem shoppingItem;
    private Double totalAmount;
    private Double tax;
    private Double totalAmountAfterTax;

    public BillPerItem(ShoppingItem shoppingItem) {
	this.shoppingItem = shoppingItem;
    }

    public Double  generateBill() {
	double totalAmount = shoppingItem.getQuantity() * shoppingItem.getItem().getUnitPrice();
	this.totalAmount=totalAmount;
	return totalAmount;
    }
    public void generateTax(){

    }

    public Double getTotalAmount() {
	return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
	this.totalAmount = totalAmount;
    }

    public Double getTax() {
	return tax;
    }

    public void setTax(Double tax) {
	this.tax = tax;
    }

    public Double getTotalAmountAfterTax() {
	return totalAmountAfterTax;
    }

    public void setTotalAmountAfterTax(Double totalAmountAfterTax) {
	this.totalAmountAfterTax = totalAmountAfterTax;
    }
}
