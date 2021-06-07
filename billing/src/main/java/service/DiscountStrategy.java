package service;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategy {
    double billAmount;
    private static Map<Integer,Double> billToDiscountMap=new HashMap<Integer, Double>();
    static{
	billToDiscountMap.put(1000,2.0);
	billToDiscountMap.put(2000,5.0);
    }
    public DiscountStrategy(double billAmount) {
	this.billAmount = billAmount;
    }

    public double getDiscountAmount() {
        if(isEligibleForDiscount()){
	    if(billAmount>=2000){
	        return billAmount*(billToDiscountMap.get(2000)/100);
	    }
	    else if(billAmount>=1000){
		return billAmount*(billToDiscountMap.get(1000)/100);
	    }
	}
	return 0.0;
    }

    private boolean isEligibleForDiscount() {
        if(billAmount>=1000 || billAmount >=2000){
            return true;
	}
	else{
	    return false;
	}
    }
}
