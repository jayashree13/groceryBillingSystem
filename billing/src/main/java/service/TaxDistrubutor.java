package service;

import model.Category;

public class TaxDistrubutor  {
    public static TaxStrategy getCategoyry(Category category){
        if(category==null){
            return null;
            //throws catgeory undefined
	}
        if(category.getCategory().equalsIgnoreCase(Category.COSMETIC.getCategory())){
            return new CosmeticTaxStrategy();
	}else if(category.getCategory().equalsIgnoreCase(Category.EATABLE.getCategory())){
	    return new EatableTaxStrategy();
	}
	else{
	    return new DailyUsageTaxStrategy();
	}
    }
}
