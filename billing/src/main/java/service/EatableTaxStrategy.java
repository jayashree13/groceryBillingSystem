package service;

public class EatableTaxStrategy implements TaxStrategy {
    //5% of tax
    public double calculateTax(double totalAmount) {
        return 0.05* totalAmount;
    }
}
