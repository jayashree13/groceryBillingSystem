package model;

public enum Category {
    EATABLE("Eatable"),DAILY_USAGE("Daily Usage"),COSMETIC("Cosmetic");
    private String category;
    Category(String category) {
        this.category=category;
    }

    public String getCategory() {
	return category;
    }
}
