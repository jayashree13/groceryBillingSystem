package service;

public class DailyUsageTaxStrategy implements TaxStrategy {
    //5% of tax
    public double calculateTax(double totalAmount) {
        return 0.08 * totalAmount;
    }
}
