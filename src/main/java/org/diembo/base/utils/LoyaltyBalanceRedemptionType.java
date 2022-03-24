package org.diembo.base.utils;

public enum LoyaltyBalanceRedemptionType {
	G("Cadeau"),
	C("Cashback"),
	;
	public static final LoyaltyBalanceRedemptionType GIFT = G;
	public static final LoyaltyBalanceRedemptionType CASH = C;
	public String getLabel() {
		return label;
	}
	private LoyaltyBalanceRedemptionType(String label) {
		this.label = label ;
	}
	private String label ;
}
