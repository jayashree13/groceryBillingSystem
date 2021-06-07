package service;

public class CosmeticTaxStrategy implements TaxStrategy {
    //5% of tax
    public double calculateTax(double totalAmount) {
        return 0.15* totalAmount;
    }
}
