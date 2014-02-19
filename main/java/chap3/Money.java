package chap3;

public class Money {
	private final int amount;
	private final String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return this.amount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Money) {
			Money money = (Money) obj;
			return money.getCurrency().equals(getCurrency())
					&& money.getAmount() == getAmount();
		}
		return false;
	}
}